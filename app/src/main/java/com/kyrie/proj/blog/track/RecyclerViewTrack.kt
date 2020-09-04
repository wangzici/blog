package com.kyrie.proj.blog.track

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * Created by wzt on 2020/9/4
 *
 */
class RecyclerViewTrack(private val recyclerView: RecyclerView) {
    val lifecycle: Lifecycle? = null

    fun startTrack() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                checkCurrentVisibleItem()
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                checkCurrentVisibleItem()
            }
        })
        lifecycle?.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) dispatchResume()
            else if (event == Lifecycle.Event.ON_PAUSE) dispatchPause()
        })
    }

    /**
     * 判断Item是否展示
     */
    private fun checkCurrentVisibleItem() {
        val range = IntArray(2)
        when (val manager = recyclerView.layoutManager) {
            is LinearLayoutManager -> {
                range[0] = manager.findFirstVisibleItemPosition()
                range[1] = manager.findLastVisibleItemPosition()
            }
        }
        
    }

    private fun dispatchPause() {
        TODO("Not yet implemented")
    }

    private fun dispatchResume() {
        TODO("Not yet implemented")
    }
}