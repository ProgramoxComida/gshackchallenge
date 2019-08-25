package io.programming4food.poh

import android.app.Application
import android.util.Log
import io.programming4food.poh.models.Categoria
import io.programming4food.poh.models.Pedido
import io.programming4food.poh.models.ResDummy
import io.programming4food.poh.retrofit.CatalogSystemAPI
import io.programming4food.poh.retrofit.DummyService
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

        //retrofit.create(CatalogSystemAPI::class.java).getCategory(77).enqueue(ListenerTest())
        //retrofit.create(CatalogSystemAPI.class).getCategoryTree().enqueue(new ListenerTest2());
        GSHackChallenge.ClientDummy.getPedidos().enqueue(ListenerTest())
        //GSHackChallenge.Client.categoryTree.enqueue(CategoryTree())
    }

    companion object {

        var BASE_URL = "https://challenge.ektdevelopers.com/api/catalog_system/"
        var BASE_URL_DUMMY = "http://13.84.224.147/"

        private var retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(
                SimpleXmlConverterFactory.createNonStrict(
                    Persister(AnnotationStrategy())
                )
            )
            .build()

        private var retrofitDummy =Retrofit.Builder().baseUrl(BASE_URL_DUMMY)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(
                SimpleXmlConverterFactory.createNonStrict(
                    Persister(AnnotationStrategy())
                )
            )
            .build()

        var Client = retrofit.create(CatalogSystemAPI::class.java )
        var ClientDummy = retrofitDummy.create(DummyService::class.java )
    }
}


internal class ListenerTest : Callback<ResDummy<ArrayList<Pedido>>> {
    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     */
    override fun onFailure(call: Call<ResDummy<ArrayList<Pedido>>>, t: Throwable) {
        Log.e("TEST","NO SIRVE")
    }

    /**
     * Invoked for a received HTTP response.
     *
     *
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call [Response.isSuccessful] to determine if the response indicates success.
     */
    override fun onResponse(
        call: Call<ResDummy<ArrayList<Pedido>>>,
        response: Response<ResDummy<ArrayList<Pedido>>>
    ) {
        Log.e("TEST",response.body().toString())
    }

}
/*

class CategoryTree : Callback<MutableList<Categoria>> {
    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     */
    override fun onFailure(call: Call<MutableList<Categoria>>, t: Throwable) {
        Log.e("TEST","NO SIRVE")
    }

    /**
     * Invoked for a received HTTP response.
     *
     *
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call [Response.isSuccessful] to determine if the response indicates success.
     */
    override fun onResponse(
        call: Call<MutableList<Categoria>>,
        response: Response<MutableList<Categoria>>
    ) {
        Log.e("TEST",response.body().toString())
    }

}

 */