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
import io.programming4food.poh.models.Producto
import java.io.Serializable

class CartAdapter(val cart: List<Producto>): RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    lateinit var _context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder: View = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        this._context = parent.context
        return ViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return cart.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //holder.title.text = this.cart[position].name

        holder.cardView.setOnClickListener {

        }
    }

    inner class ViewHolder(@NonNull itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cv_department)
        /*lateinit var title: TextView


        init {
            this.title
            this.cardView = itemView.findViewById(R.id.cv_department)
        }
        */
    }
}