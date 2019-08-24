package io.programming4food.poh.retrofit;

import java.util.List;

import io.programming4food.poh.models.Categoria;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CatalogSystemAPI {




    @GET("/api/catalog_system/pvt/category/{categoryId}")
    public Call<Categoria> getCategory(@Path("categoryId") Integer categoryId);

    @GET("/api/catalog_system/pub/category/tree/3/")
    public Call<List<Categoria> > getCategoryTree();


    //@GET("/pvt/products/:productId/specification")
    //public

}
