package com.kyrie.proj.blog.vp2

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Kyrie
 * Date: 2020/9/17
 * 简单的实现了选中功能的adapter
 */
class SimpleAdapter(private val context: Context) :
    RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    var selectedPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = TextView(context)
        val lp = ViewGroup.LayoutParams(
            300, 300
        )
        textView.layoutParams = lp
        textView.gravity = Gravity.CENTER
        textView.setBackgroundResource(android.R.color.holo_blue_light)
        return ViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder.itemView is TextView) {
            holder.itemView.text = "position = $position"
        }
        holder.itemView.setBackgroundResource(if (selectedPosition == position) android.R.color.darker_gray else android.R.color.holo_blue_light)
        holder.itemView.setOnClickListener {
            val temp = selectedPosition
            if (selectedPosition != position) {
                selectedPosition = position
                notifyItemChanged(selectedPosition)
            } else {
                selectedPosition = -1
            }
            notifyItemChanged(temp)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}