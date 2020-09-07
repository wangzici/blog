package com.kyrie.proj.blog.track

import android.graphics.Rect
import android.util.SparseLongArray
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by wzt on 2020/9/4
 *
 */
open class RecyclerViewTrack(
    private val recyclerView: RecyclerView) {
    val lifecycle: Lifecycle? = null
    private var listener: ItemExposeListener? = null
    private val timeSparseArray = SparseLongArray(10)

    fun startTrack(listener: ItemExposeListener) {
        this.listener = listener
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
        val manager = recyclerView.layoutManager
        val orientation: Int
        when (manager) {
            is LinearLayoutManager -> {
                range[0] = manager.findFirstVisibleItemPosition()
                range[1] = manager.findLastVisibleItemPosition()
                orientation = manager.orientation
            }
            else -> return
        }
        for (i in range[0]..range[1]) {
            val view = manager.findViewByPosition(i)
            checkViewVisible(view, i, orientation)
        }
    }

    private fun checkViewVisible(view: View?, position: Int, orientation: Int) {
        view?.let {
            val rect = Rect()
            val rootVisible = view.getGlobalVisibleRect(rect)
            val visibleHeightEnough =
                orientation == OrientationHelper.VERTICAL && rect.height() >= view.measuredHeight / 2
            val visibleWidthEnough =
                orientation == OrientationHelper.HORIZONTAL && rect.width() >= view.measuredWidth / 2
            //可见区域超过百分之五十
            val visible = (visibleHeightEnough || visibleWidthEnough) && rootVisible
            val lastValue = timeSparseArray[position]
            val curTime = System.currentTimeMillis()
            println("position = $position, visible = $visible, lastValue = $lastValue")
            if (lastValue > 0) {
                //从显示到不显示
                if (lastValue != curTime && !visible) {
                    timeSparseArray.put(position, -1)
                    listener?.onItemViewInvisible(position, curTime - lastValue)
                }
            } else if (visible) {
                //从不显示到显示
                timeSparseArray.put(position, curTime)
                listener?.onItemViewVisible(position)
            }
        }
    }

    private fun dispatchPause() {
        TODO("Not yet implemented")
    }

    private fun dispatchResume() {
        TODO("Not yet implemented")
    }

    interface ItemExposeListener{
        /**
         * item 可见性回调
         * 回调此方法时 视觉上一定是可见的（无论可见多少）
         * @param position item在列表中的位置
         */
        fun onItemViewVisible(position: Int)

        /**
         * item消失回调
         * @param position item在列表中的位置
         * @param showTime 曝光时间
         */
        fun onItemViewInvisible(position: Int, showTime: Long)
    }
}