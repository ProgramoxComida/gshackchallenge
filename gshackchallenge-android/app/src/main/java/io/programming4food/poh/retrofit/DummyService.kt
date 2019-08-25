package io.programming4food.poh.retrofit

import io.programming4food.poh.models.*
import retrofit2.Call
import java.util.ArrayList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyService {

    @GET("/api/v1/pedidos")
    fun getPedidos(): Call<ResDummy<ArrayList<Pedido>>>

    @GET("/api/v1/pedidos/{pedidos_id}")
    fun getPedido(@Path("pedidos_id") pedidos_id:Int): Call<ResDummy<Pedido>>

    @GET("/api/v1/pedidos/{pedidos_id}/tracking")
    fun getTracking(@Path("pedidos_id") pedidos_id:Int):Call<ResDummy<StatusPedido>>

    @GET("/api/v1/pedidos/{pedidos_id}/items/{product_id}/review")
    fun getReviewOfProductoEnPedido(@Path("pedidos_id") pedidos_id:Int,
                                    @Path("product_id") product_id:Int):Call<ResDummy<Review>>

    @GET("/api/v1/products")
    fun getProductsCat():Call<ResDummy<Producto>>

    @GET("/api/v1/products")
    fun getProductsCatCategoryID(@Query("categoryId") categoryId:Int):Call<ResDummy<Producto>>

    @GET("/api/v1/products")
    fun getProductsCatBrandId(@Query("brandId") brandId:Int):Call<ResDummy<Producto>>

    @GET("/api/v1/user_profile")
    fun getUserProfile():Call<ResDummy<Profile>>
}