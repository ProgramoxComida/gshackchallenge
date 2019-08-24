<?php

namespace App\Http\Controllers;

class PedidosController extends Controller
{
    public function __construct()
    {
        $this->data = [
            ['id' => 'EKT-0000001', 'created_at' => '26/08/2019', 'items' => [
                ['sku' => 1, 'brand' => 'SONY', 'sku_name' => 'Pantalla LCD Sony 46 Pulgadas HD KDL-46V5100'],
                ['sku' => 4, 'brand' => 'MASTER', 'sku_name' => 'Antena Plana Para Interiores Master TVANTFLATHD'],
                ['sku' => 5, 'brand' => 'MASTER', 'sku_name' => 'Control Universal Master - RMHD1080']]],

            ['id' => 'EKT-0000002', 'created_at' => '27/08/2019', 'items' => [
                ['sku' => 11, 'brand' => 'POWER & CO', 'sku_name' => 'Antena HDF FLAT X100 INT 2M'],
                ['sku' => 12, 'brand' => 'ENERGIZER', 'sku_name' => 'Energizer Cable Micro-HDMI Negro'],
                ['sku' => 13, 'brand' => 'ROKU', 'sku_name' => 'Roku Streaming Express Plus ROK3710MX']]]
        ];

        $this->tracking = [
            ["id" => "TRK-0000001", "pedido_id" =>  "EKT-0000001", "status" => "Ordenado", "events" => []],
            ["id" => "TRK-0000001", "pedido_id" =>  "EKT-0000001", "status" => "Ordenado", "events" => []],
            ["id" => "TRK-0000002", "pedido_id" =>  "EKT-0000002", "status" => "Ordenado", "events" => []],
            ["id" => "TRK-0000002", "pedido_id" =>  "EKT-0000002", "status" => "Enviado", "events" => [["message" => "Recogido de las instalaciones por el transportista"]]],
            ["id" => "TRK-0000002", "pedido_id" =>  "EKT-0000002", "status" => "Enviado", "events" => [["message" => "Llego a las instalaciones del tranportista"]]],
            ["id" => "TRK-0000002", "pedido_id" =>  "EKT-0000002", "status" => "En Proceso de Entrega", "events" => [
                ["message" => "Recogido de las instalaciones por el transportista para ser entregado"]]],
            ["id" => "TRK-0000002", "pedido_id" =>  "EKT-0000002", "status" => "En Curso de Entrega", "events" => []],
            ["id" => "TRK-0000002", "pedido_id" =>  "EKT-0000002", "status" => "Entregado", "events" => [
                ["message" => "Paquete entregado a recepcion", "receive" =>  "Martin Iglesias"]
            ]],
        ];

    }
    /**
     * @OA\Get(
     *     path="/api/v1/pedidos",
     *     operationId="PedidosList",
     *     tags={"Pedidos"},
     *     summary="Listado de Pedidos",
     *     description="Este endpoint retorna los pedidos",
     *     @OA\Response(
     *         response=200,
     *         description="successful operation",
     *         @OA\JsonContent(ref="#/components/schemas/Pedido")
     *     ),
     *     @OA\Response(
     *         response="400",
     *         description="Invalid credentials",
     *         @OA\JsonContent(ref="#/components/schemas/Error")
     *     ),
     *     @OA\Response(
     *         response="500",
     *         description="Couldn't Create Token",
     *         @OA\JsonContent(ref="#/components/schemas/Error")
     *     )
     * )
     */
    public function getPedidos() {
        try {
            return response()->json([
                'status' => true,
                'data' => $this->data
            ]);
        } catch (Exception $ex) {
            return response()->json([
                'status' => false,
                'error' => 'error_interno'
            ], 400);
        }
    }
    /**
     * @OA\Get(
     *     path="/api/v1/pedidos/{pedidos_id}",
     *     operationId="Pedido",
     *     tags={"Pedidos"},
     *     summary="Detalle del pedido",
     *     description="Este endpoint retorna los pedidos",
     *     @OA\Response(
     *         response=200,
     *         description="successful operation",
     *         @OA\JsonContent(ref="#/components/schemas/Pedido")
     *     ),
     *     @OA\Response(
     *         response="400",
     *         description="Invalid credentials",
     *         @OA\JsonContent(ref="#/components/schemas/Error")
     *     ),
     *     @OA\Response(
     *         response="500",
     *         description="Couldn't Create Token",
     *         @OA\JsonContent(ref="#/components/schemas/Error")
     *     )
     * )
     */
    public function getPedido($pedido_id) {
        try {
            $a = [];
            foreach ($this->data as $item) {
                if($item['id'] == $pedido_id) {
                    $a = $item;
                }
            }
            return response()->json([
                'status' => true,
                'data' => $a
            ]);
        } catch (Exception $ex) {
            return response()->json([
                'status' => false,
                'error' => 'error_interno'
            ], 400);
        }
    }
    /**
     * @OA\Get(
     *     path="/api/v1/pedidos/{pedidos_id}/tracking",
     *     operationId="PedidoTracking",
     *     tags={"Pedidos"},
     *     summary="Detalle de envio del pedido",
     *     description="Este endpoint retorna el estado de envio de un pedido",
     *     @OA\Response(
     *         response=200,
     *         description="successful operation",
     *         @OA\JsonContent(ref="#/components/schemas/Pedido")
     *     ),
     *     @OA\Response(
     *         response="400",
     *         description="Invalid credentials",
     *         @OA\JsonContent(ref="#/components/schemas/Error")
     *     ),
     *     @OA\Response(
     *         response="500",
     *         description="Couldn't Create Token",
     *         @OA\JsonContent(ref="#/components/schemas/Error")
     *     )
     * )
     */
    public function getPedidoTracking($pedido_id) {
        try {
            $a = [];
            foreach ($this->tracking as $item) {
                if($item['pedido_id'] == $pedido_id) {
                    // $a = $item;
                    array_push($a, $item);
                }
            }
            return response()->json([
                'status' => true,
                'data' => $a
            ]);
        } catch (Exception $ex) {
            return response()->json([
                'status' => false,
                'error' => 'error_interno'
            ], 400);
        }
    }
}
