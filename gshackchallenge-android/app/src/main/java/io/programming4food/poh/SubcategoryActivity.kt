package io.programming4food.poh

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.programming4food.poh.adapters.CategoriesAdapter
import io.programming4food.poh.models.Categoria

class SubcategoryActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subcategory)

        var toolbar: Toolbar = findViewById(R.id.toolbar_main_subcategory)
        toolbar.title = "Seleccione una Categoría"
        toolbar.setTitleTextColor(getColor(R.color.elektraRed))

        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        var extras = intent.extras
        var itemCategoria = extras.getSerializable("ITEM") as Categoria

        var layoutManager = LinearLayoutManager(this@SubcategoryActivity)
        var recyclerView = findViewById<RecyclerView>(R.id.rv_subcategories)
        recyclerView.layoutManager = layoutManager

        var departmentsAdapter = CategoriesAdapter(itemCategoria.children)
        recyclerView.adapter = departmentsAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId === android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }
}
