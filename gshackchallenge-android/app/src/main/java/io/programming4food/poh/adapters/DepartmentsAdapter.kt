package io.programming4food.poh.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import io.programming4food.poh.R
import io.programming4food.poh.SubcategoryActivity
import io.programming4food.poh.models.Categoria
import java.io.Serializable

class DepartmentsAdapter(departments: List<Categoria>): RecyclerView.Adapter<DepartmentsAdapter.ViewHolder>() {
    lateinit var departments: List<Categoria>
    lateinit var _context: Context

    init {
        this.departments = departments
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var holder: View = LayoutInflater.from(parent.context).inflate(R.layout.department_item, parent, false)
        this._context = parent.context
        return ViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return departments.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("STAT", this.departments[position].id.toString())
        holder.title.text = this.departments[position].name

        holder.cardView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                var i: Intent = Intent(_context, SubcategoryActivity::class.java)
                i.putExtra("ITEM", departments[position] as Serializable)
                _context.startActivity(i)
            }
        })
    }

    inner class ViewHolder(@NonNull itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var title: TextView
        lateinit var cardView: CardView

        init {
            this.title = itemView.findViewById(R.id.txt_title)
            this.cardView = itemView.findViewById(R.id.cv_department)
        }
    }
}