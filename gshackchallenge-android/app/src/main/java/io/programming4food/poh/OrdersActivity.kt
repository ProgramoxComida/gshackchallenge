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

class OrdersActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        var toolbar: Toolbar = findViewById(R.id.toolbar_main_orders)
        toolbar.title = "Mis Pedidos"
        toolbar.setTitleTextColor(getColor(R.color.elektraRed))

        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        var btnMonitor = findViewById<Button>(R.id.btn_monitor)
        btnMonitor.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                var i: Intent = Intent(this@OrdersActivity, TrackingActivity::class.java)
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
