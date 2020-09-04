package com.kyrie.proj.blog.track.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kyrie.proj.blog.R
import com.kyrie.proj.blog.track.model.Product

/**
 * Created by wzt on 2020/9/4
 *
 */
class ProductAdapter(private val context: Context, private var list: MutableList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.tvPrice.text = list[position].price.toString()
        holder.tvTitle.text = list[position].name
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvPrice : TextView = itemView.findViewById(R.id.tv_price)
    }
}