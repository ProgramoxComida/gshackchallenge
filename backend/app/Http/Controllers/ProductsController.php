<?php

namespace App\Http\Controllers;

use PhpOffice\PhpSpreadsheet\Spreadsheet;
use PhpOffice\PhpSpreadsheet\IOFactory;
use Illuminate\Http\Request;

class ProductsController extends Controller
{
    /**
     * @OA\Get(
     *     path="/api/v1/products",
     *     operationId="ProductsList",
     *     tags={"Products"},
     *     summary="Listado de Productos",
     *     description="Este endpoint retorna los productos del catalogo de Elektra que vienen del Dataset",
     *     @OA\Parameter(
     *          name="categoryId",
     *          in="query",
     *          required=false,
     *          @OA\Schema(
     *              type="string"
     *          ),
     *          description="ID de Categoria",
     * 		),
     *     @OA\Parameter(
     *          name="brandId",
     *          in="query",
     *          required=false,
     *          @OA\Schema(
     *              type="string"
     *          ),
     *          description="ID de Brand",
     * 		),
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
    public function get_products(Request $request) {
        $spreadsheet = IOFactory::load(public_path().'/stockKeepingUnitReport_Dummy_HackChallenge.xls');
        $sheetData = $spreadsheet->getActiveSheet()->toArray(null, true, true, true);
        // var_dump($sheetData);
        // $spreadsheet = $reader->load(public_path().'/stockKeepingUnitReport_Dummy_HackChallenge.xls');
        // print_r($spreadsheet);
        $catId = $request->input('categoryId', '');
        $brandId = $request->input('brandId', '');
        $catalog = [];
        for ($i = 2; $i < count($sheetData); $i++) {
            $row = $sheetData[$i];
            if ($catId != '') {
                if ($catId == $row["AK"]) {
                    $catalog[] = ["sku" => $row['A'], "sku_name" => $row['A'], "product_name" => $row["U"], "product_short_desc" => $row["V"],
                    "meta_desc" => $row["AE"], "departament_id" => $row["AI"], "departament_name" => $row["AJ"],
                    "category_id" => $row["AK"], "category_name" => $row["AL"], "brand_id" => $row["AM"],
                    "brand" => $row["AN"]];
                }
            } else if ($brandId != '') {
                if ($brandId == $row["AM"]) {
                    $catalog[] = ["sku" => $row['A'], "sku_name" => $row['A'], "product_name" => $row["U"], "product_short_desc" => $row["V"],
                    "meta_desc" => $row["AE"], "departament_id" => $row["AI"], "departament_name" => $row["AJ"],
                    "category_id" => $row["AK"], "category_name" => $row["AL"], "brand_id" => $row["AM"],
                    "brand" => $row["AN"]];
                }
            } else {
                $catalog[] = ["sku" => $row['A'], "sku_name" => $row['A'], "product_name" => $row["U"], "product_short_desc" => $row["V"],
                    "meta_desc" => $row["AE"], "departament_id" => $row["AI"], "departament_name" => $row["AJ"],
                    "category_id" => $row["AK"], "category_name" => $row["AL"], "brand_id" => $row["AM"],
                    "brand" => $row["AN"]];
            }
        }
        return response()->json([
            'status' => true,
            'data' => $catalog
        ]);
    }
}
