package io.programming4food.poh

import android.app.Application
import android.util.Log
import io.programming4food.poh.models.Categoria
import io.programming4food.poh.models.Pedido
import io.programming4food.poh.models.ResDummy
import io.programming4food.poh.retrofit.CatalogSystemAPI
import io.programming4food.poh.retrofit.DummyService
import io.programming4food.poh.retrofit.ElektraServices
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.ArrayList

class GSHackChallenge : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object {

        private var retrofit = Retrofit.Builder().baseUrl(CatalogSystemAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(
                SimpleXmlConverterFactory.createNonStrict(
                    Persister(AnnotationStrategy())
                )
            )
            .build()

        private var retrofitDummy =Retrofit.Builder().baseUrl(DummyService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(
                SimpleXmlConverterFactory.createNonStrict(
                    Persister(AnnotationStrategy())
                )
            )
            .build()

        private var retrofitElectra =Retrofit.Builder().baseUrl(ElektraServices.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(
                SimpleXmlConverterFactory.createNonStrict(
                    Persister(AnnotationStrategy())
                )
            )
            .build()

        var Client: CatalogSystemAPI = retrofit.create(CatalogSystemAPI::class.java )
        var ClientDummy: DummyService = retrofitDummy.create(DummyService::class.java )
        var ClientElektra: ElektraServices = retrofitElectra.create(ElektraServices::class.java)
    }
}