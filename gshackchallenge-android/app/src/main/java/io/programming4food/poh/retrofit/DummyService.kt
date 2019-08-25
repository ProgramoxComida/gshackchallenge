package io.programming4food.poh.retrofit

import io.programming4food.poh.models.Pedido
import io.programming4food.poh.models.ResDummy
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DummyService {

    @GET("/api/v1/pedidos")
    fun getPedidos(): Call<ResDummy<List<Pedido>>>

    @GET("/api/v1/pedidos/{pedidos_id}")
    fun getPedido(@Path("pedidos_id") pedidos_id:Int)

    @GET("/api/v1/pedidos/{pedidos_id}/tracking")
    fun getTracking(@Path("pedidos_id") pedidos_id:Int)

    @GET("/api/v1/pedidos/{pedidos_id}/items/{product_id}/review")
    fun getReviewOfProductoEnPedido(@Path("pedidos_id") pedidos_id:Int,@Path("product_id") product_id:Int)

    @GET("/api/v1/products")
    fun getProductsCat()

}