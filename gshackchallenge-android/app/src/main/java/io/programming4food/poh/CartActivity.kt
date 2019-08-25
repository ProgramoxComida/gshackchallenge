package io.programming4food.poh

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.programming4food.poh.adapters.CartAdapter
import io.programming4food.poh.models.Producto
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        var toolbar: Toolbar = findViewById(R.id.toolbar_main_cart)
        toolbar.title = "Mi Carrito"
        toolbar.setTitleTextColor(getColor(R.color.elektraRed))

        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        var payButton: Button = findViewById(R.id.btn_pay_credit_card)

        var layoutManager = LinearLayoutManager(this@CartActivity)
        recyclerView.layoutManager = layoutManager
        var cartAdapter = CartAdapter( listOf( Producto(),Producto(), Producto(),Producto(),Producto(),Producto()) ) // Cambiar por servicio
        recyclerView.adapter = cartAdapter

        payButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                var i = Intent(this@CartActivity, PaymentActivity::class.java)
                startActivity(i)
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId === android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }
}
