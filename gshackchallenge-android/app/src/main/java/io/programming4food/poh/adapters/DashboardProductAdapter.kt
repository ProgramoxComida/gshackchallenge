package io.programming4food.poh.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.programming4food.poh.R
import io.programming4food.poh.SubcategoryActivity
import io.programming4food.poh.models.Categoria
import io.programming4food.poh.models.Producto
import io.programming4food.poh.models.ProductoDetalle
import java.io.Serializable

class DashboardProductAdapter(val productos: List<ProductoDetalle>): RecyclerView.Adapter<DashboardProductAdapter.ViewHolder>() {
    lateinit var _context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder: View = LayoutInflater.from(parent.context).inflate(R.layout.product_item_dashboard, parent, false)
        this._context = parent.context
        return ViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var item = productos[position]
        //holder.title.text = this.cart[position].name

        var a = item.images.flatten()

        Glide.with(_context).load(a[0]).into(holder.imagen)


        holder.cardView.setOnClickListener {

        }
    }

    inner class ViewHolder(@NonNull itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cv_department)
        val imagen:ImageView = itemView.findViewById(R.id.imagen)



    }
}