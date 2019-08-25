<?php

namespace App\Http\Controllers;
use Illuminate\Http\Request;

class UserController extends Controller
{
    /**
     * @OA\Get(
     *     path="/api/v1/user_profile",
     *     operationId="Profile",
     *     tags={"User"},
     *     summary="Perfil Usuario",
     *     description="Este endpoint retorna el perfil del usuario",
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
    public function getProfile() {
        try {
            return response()->json([
                'status' => true,
                'data' => [
                    "Nombre" => "Martin",
                    "Apellidos" => "Morales Sordo",
                    "Email" => "unmail@sample.com",
                    "Telefono" => "55-4789-5896",
                    "Direccion" => [
                        "Calle" => "Av Toluca",
                        "NumExt" => "25-A",
                        "NumInt" => "7",
                        "CP" => "15957",
                        "Referencia" => "Edificio cercano al lago toluca"
                    ],
                    "Pedidos" => [
                        'EKT-0000001', 'EKT-0000002'
                    ]
                ]
            ]);
        } catch (Exception $ex) {
            return response()->json([
                'status' => false,
                'error' => 'error_interno'
            ], 400);
        }
    }
}
