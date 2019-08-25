package io.programming4food.poh.retrofit

import androidx.annotation.Nullable
import io.programming4food.poh.models.ProductoDetalle
import io.programming4food.poh.models.ProductoElektraCluster
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ElektraServices {

    companion object {
        var BASE_URL = "https://www.elektra.com.mx/"
    }


    /*
    * Order
    *
    * OrderByTopSaleDESC
    * */

    @GET("/api/catalog_system/pub/products/search")
    fun searchCatalog(@Query("_from") from:Int,
                      @Query("_to") to:Int,
                      @Query("O") order:String?,
                      @Query("fq") productCluster:String?): Call<List<ProductoElektraCluster>>

    @GET("/produto/sku/{sku}")
    fun getProductoBySku(@Path("sku") sku:String):Call<ProductoDetalle>
}