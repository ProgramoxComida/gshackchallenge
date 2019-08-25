package io.programming4food.poh

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.programming4food.poh.adapters.DepartmentsAdapter
import io.programming4food.poh.models.Categoria
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DepartmentsActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_departments)

        var toolbar: Toolbar = findViewById(R.id.toolbar_main_departments)
        toolbar.title = "Departamentos"
        toolbar.setTitleTextColor(getColor(R.color.elektraRed))

        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        var layoutManager = GridLayoutManager(this@DepartmentsActivity, 2)
        var recyclerView = findViewById<RecyclerView>(R.id.rv_departments)
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = layoutManager

        var categoria = GSHackChallenge.Client.categoryTree

        categoria.enqueue(object: Callback<List<Categoria>> {
            override fun onFailure(call: Call<List<Categoria>>, t: Throwable) {
                Log.e("ERR", t.message)
            }

            override fun onResponse(call: Call<List<Categoria>>, response: Response<List<Categoria>>) {
                Log.d("STAT", call.request().url().toString())
                if(response.code() == 200) {
                    var list = response.body()
                    var departmentsAdapter = DepartmentsAdapter(list!!)

                    recyclerView.adapter = departmentsAdapter
                } else {

                }
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
