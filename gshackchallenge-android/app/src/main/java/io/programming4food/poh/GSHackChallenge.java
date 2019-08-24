package io.programming4food.poh;

import android.app.Application;
import android.util.Log;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.util.List;

import io.programming4food.poh.models.Categoria;
import io.programming4food.poh.retrofit.CatalogSystemAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class GSHackChallenge extends Application {

    static public String BASE_URL = "https://challenge.ektdevelopers.com/api/catalog_system/";
    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(
                    new Persister(new AnnotationStrategy())
            ))
            .build();


    @Override
    public void onCreate() {
        super.onCreate();

        retrofit.create(CatalogSystemAPI.class).getCategory(77).enqueue(new ListenerTest());
        //retrofit.create(CatalogSystemAPI.class).getCategoryTree().enqueue(new ListenerTest2());
    }
}

class ListenerTest2 implements Callback<List<Categoria>> {
    /**
     * Invoked for a received HTTP response.
     * <p>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccessful()} to determine if the response indicates success.
     *
     * @param call
     * @param response
     */
    @Override
    public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
        Log.e("LLamada Test Lista",response.body().toString());
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<List<Categoria>> call, Throwable t) {
        Log.e("NO SIRVES","NO SIRVES");
    }
}

class ListenerTest implements Callback<Categoria> {

    /**
     * Invoked for a received HTTP response.
     * <p>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccessful()} to determine if the response indicates success.
     *
     * @param call
     * @param response
     */
    @Override
    public void onResponse(Call<Categoria> call, Response<Categoria> response) {
        Log.e("LLamada Test",response.body().toString());
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<Categoria> call, Throwable t) {
        Log.e("NO SIRVES Lista","NO SIRVES");
    }
}