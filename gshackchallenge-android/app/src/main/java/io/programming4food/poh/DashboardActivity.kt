package io.programming4food.poh

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import io.programming4food.poh.adapters.DashboardProductAdapter
import io.programming4food.poh.models.Producto
import io.programming4food.poh.models.ProductoDetalle
import io.programming4food.poh.models.ProductoElektraCluster
import io.programming4food.poh.models.ResDummy
import kotlinx.android.synthetic.main.content_dashboard.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class DashboardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {



    val sampleImg = listOf(R.drawable.img1,R.drawable.img2,R.drawable.img3)
    val prodDemo:MutableList<ProductoDetalle> = mutableListOf<ProductoDetalle>()
    val adapter: DashboardProductAdapter = DashboardProductAdapter(prodDemo)
    //lateinit val carouselView: CarouselView
    //val imageListener = ImageListener { position, imageView -> imageView.setImageResource(sampleImg[position])  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        carouselView.pageCount = sampleImg.size
        carouselView.setImageListener { position, imageView -> imageView.setImageResource(sampleImg[position]) }

        GSHackChallenge.ClientElektra
            .searchCatalog(1,10, "OrderByTopSaleDESC", "productClusterIds:1157")
            .enqueue(object:Callback<List<ProductoElektraCluster>>{
                override fun onFailure(call: Call<List<ProductoElektraCluster>>, t: Throwable) {
                    Toast.makeText(this@DashboardActivity,"Verifica tu conexion a Internet",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<ProductoElektraCluster>>,
                    response: Response<List<ProductoElektraCluster>>
                ) {
                    if ( response.isSuccessful ){
                        prodDemo.clear()

                        response.body()?.forEach {
                            GSHackChallenge.ClientElektra.getProductoBySku(it.productId)
                                .enqueue(object:Callback<List<ProductoDetalle>>{
                                    override fun onFailure(
                                        call: Call<List<ProductoDetalle>>,
                                        t: Throwable
                                    ) {
                                        Toast.makeText(this@DashboardActivity,"Verifica tu conexion a Internet",Toast.LENGTH_SHORT).show()
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

        var layoutManager = GridLayoutManager(this@DashboardActivity, 2)
        productosD.setHasFixedSize(true)

        //var departmentsAdapter = DepartmentsAdapter(list!!)
        productosD.layoutManager = layoutManager
        productosD.adapter = adapter

    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.nav_cart -> {
                var i: Intent = Intent(this@DashboardActivity, CartActivity::class.java)
                startActivity(i)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_departamentos -> {
                val i: Intent = Intent(this@DashboardActivity, DepartmentsActivity::class.java)
                startActivity(i)
            }

            R.id.nav_pedidos -> {
                val i: Intent = Intent(this@DashboardActivity, LoginActivity::class.java)
                startActivity(i)
            }
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
