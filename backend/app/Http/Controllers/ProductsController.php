<?php

namespace App\Http\Controllers;

use PhpOffice\PhpSpreadsheet\Spreadsheet;


class ProductsController extends Controller
{
    /**
     * @OA\Get(
     *     path="/api/v1/products",
     *     operationId="ProductsList",
     *     tags={"Products"},
     *     summary="Listado de Productos",
     *     description="Este endpoint retorna los productos del catalogo de Elektra que vienen del Dataset",
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
    public function get_products() {
        /** Load $inputFileName to a Spreadsheet Object  **/
        $reader = new \PhpOffice\PhpSpreadsheet\Reader\Xls();
        /** Load $inputFileName to a Spreadsheet Object  **/
        $spreadsheet = $reader->load(public_path().'stockKeepingUnitReport_Dummy_HackChallenge.xls');
        print_r($spreadsheet);
    }
}
