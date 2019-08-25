package io.programming4food.poh.retrofit

import io.programming4food.poh.models.Pedido
import io.programming4food.poh.models.ResDummy
import retrofit2.Call
import retrofit2.http.GET

interface DummyService {

    @GET("/api/v1/pedidos")
    fun getPedidos(): Call<ResDummy<List<Pedido>>>
}