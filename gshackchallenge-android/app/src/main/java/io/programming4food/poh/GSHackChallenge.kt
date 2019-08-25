package io.programming4food.poh

import android.app.Application
import android.util.Log
import io.programming4food.poh.models.Categoria
import io.programming4food.poh.retrofit.CatalogSystemAPI
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class GSHackChallenge : Application() {
    internal var retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(
            SimpleXmlConverterFactory.createNonStrict(
                Persister(AnnotationStrategy())
            )
        )
        .build()


    override fun onCreate() {
        super.onCreate()

        retrofit.create(CatalogSystemAPI::class.java).getCategory(77).enqueue(ListenerTest())
        //retrofit.create(CatalogSystemAPI.class).getCategoryTree().enqueue(new ListenerTest2());
    }

    companion object {

        var BASE_URL = "https://challenge.ektdevelopers.com/api/catalog_system/"
    }
}

internal class ListenerTest : Callback<Categoria> {

    /**
     * Invoked for a received HTTP response.
     *
     *
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call [Response.isSuccessful] to determine if the response indicates success.
     *
     * @param call
     * @param response
     */
    override fun onResponse(call: Call<Categoria>, response: Response<Categoria>) {
        Log.e("LLamada Test", response.body()!!.toString())
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     *
     * @param call
     * @param t
     */
    override fun onFailure(call: Call<Categoria>, t: Throwable) {
        Log.e("NO SIRVES Lista", "NO SIRVES")
    }
}