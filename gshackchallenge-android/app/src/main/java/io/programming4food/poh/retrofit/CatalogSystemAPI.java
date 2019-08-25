package io.programming4food.poh.retrofit;

import java.util.List;

import io.programming4food.poh.models.Categoria;
import io.programming4food.poh.models.Marca;
import io.programming4food.poh.models.Producto;
import io.programming4food.poh.models.ProductsAndSKUS;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CatalogSystemAPI {


    String BASE_URL = "https://challenge.ektdevelopers.com/api/catalog_system/";

    @GET("/api/catalog_system/pvt/category/{categoryId}")
    public Call<Categoria> getCategory(@Path("categoryId") Integer categoryId);

    @GET("/api/catalog_system/pub/category/tree/3/")
    public Call<List<Categoria> > getCategoryTree();


    @GET("/api/catalog_system/pvt/brand/list")
    public Call<List<Marca>> getBrandList();

    @GET("/api/catalog_system/pvt/brand/{brandId}")
    public Call<Marca> getMarca(Integer brandId);

    @GET("/api/catalog_system/pvt/products/ProductGet/{productId}")
    public Call<Producto> getProductoById(@Path("productId") Integer productId);

    @GET("/api/catalog_system/pvt/products/GetProductAndSkuIds")
    public Call<ProductsAndSKUS> getProductsAndSKUS(@Query("categoryId") Integer categoryId,
                                                    @Query("from") Integer from,
                                                    @Query("to") Integer to);




    //@GET("/pvt/products/:productId/specification")
    //public

}
