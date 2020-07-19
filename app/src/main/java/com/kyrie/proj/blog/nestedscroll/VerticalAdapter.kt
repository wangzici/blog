package com.kyrie.proj.blog.nestedscroll

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kyrie.proj.blog.R

/**
 * Created by Kyrie
 * Date: 2020/7/19
 *
 */
class VerticalAdapter(context: Context) : RecyclerView.Adapter<VerticalAdapter.HorizonViewHolder>() {
    private val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizonViewHolder {
        val view =
            LayoutInflater.from(mContext).inflate(R.layout.item_vertical_recycleview, parent, false)
        return HorizonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: HorizonViewHolder, position: Int) {
        holder.tvTitleVertical.text = "item $position"
    }

    class HorizonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitleVertical: TextView = itemView.findViewById(R.id.tv_title_vertical)
    }
}