package io.programming4food.poh.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import io.programming4food.poh.ProductsActivity
import io.programming4food.poh.R
import io.programming4food.poh.models.Categoria

class CategoriesAdapter(categories: List<Categoria>): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    lateinit var categories: List<Categoria>
    lateinit var _context: Context

    init {
        this.categories = categories
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var holder: View = LayoutInflater.from(parent.context).inflate(R.layout.category_horizontal_item, parent, false)
        this._context = parent.context
        return ViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return this.categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = this.categories[position].name

        holder.container.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                var i: Intent = Intent(_context, ProductsActivity::class.java)
                _context.startActivity(i)
            }

        })
    }

    inner class ViewHolder(@NonNull itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var title: TextView
        lateinit var container: ConstraintLayout

        init {
            this.title = itemView.findViewById(R.id.txt_category_name)
            this.container = itemView.findViewById(R.id.cl_category_container)
        }
    }
}