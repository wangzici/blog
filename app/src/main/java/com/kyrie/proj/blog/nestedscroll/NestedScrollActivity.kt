package com.kyrie.proj.blog.nestedscroll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kyrie.proj.blog.R
import kotlinx.android.synthetic.main.activity_nested_scroll.*

/**
 * Created by Kyrie
 * Date: 2020/7/19
 * 嵌套滑动的activity，含有两个RecycleView
 */
class NestedScrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_scroll)
        initRecycleView()
    }

    private fun initRecycleView() {
        rv_horizon.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv_horizon.adapter = HorizonAdapter(this)
    }
}