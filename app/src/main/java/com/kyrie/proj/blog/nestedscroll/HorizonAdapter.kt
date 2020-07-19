package com.kyrie.proj.blog.nestedscroll

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kyrie.proj.blog.R

/**
 * Created by Kyrie
 * Date: 2020/7/19
 *
 */
class HorizonAdapter(context: Context) : RecyclerView.Adapter<HorizonAdapter.HorizonViewHolder>() {
    private val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizonViewHolder {
        val view =
            LayoutInflater.from(mContext).inflate(R.layout.item_horizon_recycleview, parent, false)
        return HorizonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: HorizonViewHolder, position: Int) {
        holder.tvTitleHorizon.text = "item $position"
        holder.rvVertical.layoutManager =
            LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        holder.rvVertical.adapter = VerticalAdapter(mContext)
    }

    class HorizonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitleHorizon: TextView = itemView.findViewById(R.id.tv_title_horizon)
        val rvVertical: RecyclerView = itemView.findViewById(R.id.rv_vertical)

    }
}