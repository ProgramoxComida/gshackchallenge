package io.programming4food.poh.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
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
    }

    inner class ViewHolder(@NonNull itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var title: TextView

        init {
            this.title = itemView.findViewById(R.id.txt_category_name)
        }
    }
}