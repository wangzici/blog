package com.kyrie.proj.blog.nestedscroll

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs
import kotlin.math.asin
import kotlin.math.roundToInt
import kotlin.math.sqrt

/**
 * Created by Kyrie
 * Date: 2020/7/19
 *
 */
class VerticalRecycleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("wzt", "[VerticalRecycleView][dispatchTouchEvent] ev = ${MotionEvent.actionToString(ev!!.action)}")
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = ev.x
                downY = ev.y
                Log.i("wzt","[VerticalRecycleView][dispatchTouchEvent]不允许父控件拦截")
                getParentRecycleView()?.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                val currentX = ev.x
                val currentY = ev.y
                val x = abs(currentX - downX)
                val y = abs(currentY - downY)
                //                KLog.i("downX = " + downX + "downY = " + downY + "currentX = " + currentX + ";currentY = " + currentY + ";angle = " + angle);
                //大于45度表示处于上下滑动
                if (y < x) {
                    //表示我不需要消费此事件
                    Log.i("wzt","允许拦截")
                    getParentRecycleView()?.requestDisallowInterceptTouchEvent(false)
                }
            }
        }
        val result = super.dispatchTouchEvent(ev)
        Log.i("wzt", "[VerticalRecycleView][dispatchTouchEvent] return $result")
        return result
    }

    var downX = 0f
    var downY = 0f
    override fun onTouchEvent(e: MotionEvent?): Boolean {
        Log.i("wzt", "[VerticalRecycleView][onTouchEvent] e = = ${MotionEvent.actionToString(e!!.action)}")
        val result = super.onTouchEvent(e)
        Log.i("wzt", "[VerticalRecycleView][onTouchEvent] return $result")
        return result
    }

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        Log.i("wzt", "[VerticalRecycleView][onInterceptTouchEvent] e = ${MotionEvent.actionToString(e!!.action)}")
        val result = super.onInterceptTouchEvent(e)
        Log.i("wzt", "[VerticalRecycleView][onInterceptTouchEvent] return $result")
        return result
    }

    /**
     * 返回父RecycleView，这里直接往上级最高三层查找
     */
    private fun getParentRecycleView() :RecyclerView? {
        return when {
            parent is RecyclerView -> parent as RecyclerView
            parent.parent is RecyclerView -> parent.parent as RecyclerView
            parent.parent.parent is RecyclerView -> parent.parent.parent as RecyclerView
            else -> null
        }
    }
}