package io.programming4food.poh

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.navigation.NavigationView
import io.programming4food.poh.adapters.DashboardProductAdapter
import io.programming4food.poh.models.ProductoDetalle
import io.programming4food.poh.models.ProductoElektraCluster
import kotlinx.android.synthetic.main.content_dashboard.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsActivity : AppCompatActivity() {
    val prodDemo:MutableList<ProductoDetalle> = mutableListOf<ProductoDetalle>()
    val adapter: DashboardProductAdapter = DashboardProductAdapter(prodDemo)
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        var toolbar: Toolbar = findViewById(R.id.toolbar_main_products)
        toolbar.title = "Productos Disponibles"
        toolbar.setTitleTextColor(getColor(R.color.elektraRed))

        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        /*val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()*/

        //"productClusterIds:1157"
        GSHackChallenge.ClientElektra
            .searchCatalog(1,10, "OrderByTopSaleDESC", null)
            .enqueue(object: Callback<List<ProductoElektraCluster>> {
                override fun onFailure(call: Call<List<ProductoElektraCluster>>, t: Throwable) {
                    Toast.makeText(this@ProductsActivity,"Verifica tu conexion a Internet", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<ProductoElektraCluster>>,
                    response: Response<List<ProductoElektraCluster>>
                ) {
                    if ( response.isSuccessful ){
                        prodDemo.clear()

                        response.body()?.forEach {
                            GSHackChallenge.ClientElektra.getProductoBySku(it.productId)
                                .enqueue(object: Callback<List<ProductoDetalle>> {
                                    override fun onFailure(
                                        call: Call<List<ProductoDetalle>>,
                                        t: Throwable
                                    ) {
                                        Toast.makeText(this@ProductsActivity,"Verifica tu conexion a Internet",
                                            Toast.LENGTH_SHORT).show()
                                    }

                                    override fun onResponse(
                                        call: Call<List<ProductoDetalle>>,
                                        response: Response<List<ProductoDetalle>>
                                    ) {
                                        if(response.isSuccessful){
                                            response.body()?.apply {
                                                //prodDemo.add(this)
                                                this.forEach {
                                                    prodDemo.add(it)
                                                }
                                                adapter.notifyDataSetChanged()
                                            }
                                        }

                                    }

                                })
                        }

                    }
                }

            })

        var layoutManager = GridLayoutManager(this@ProductsActivity, 2)
        productosD.setHasFixedSize(true)

        //var departmentsAdapter = DepartmentsAdapter(list!!)
        productosD.layoutManager = layoutManager
        productosD.adapter = adapter

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId === android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }
}
