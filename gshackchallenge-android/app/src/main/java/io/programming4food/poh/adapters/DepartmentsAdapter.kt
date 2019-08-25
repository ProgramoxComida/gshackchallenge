package io.programming4food.poh.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import io.programming4food.poh.R
import io.programming4food.poh.models.Categoria

class DepartmentsAdapter(departments: ArrayList<Categoria>): RecyclerView.Adapter<DepartmentsAdapter.ViewHolder>() {
    lateinit var departments: ArrayList<Categoria>

    init {
        this.departments = departments
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var holder: View = LayoutInflater.from(parent.context).inflate(R.layout.department_item, parent, false)
        return ViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return departments.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    inner class ViewHolder(@NonNull itemView: View): RecyclerView.ViewHolder(itemView) {
        init {

        }
    }
}