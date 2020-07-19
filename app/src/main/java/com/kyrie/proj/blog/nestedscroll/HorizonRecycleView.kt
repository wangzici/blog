package com.kyrie.proj.blog.nestedscroll

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Kyrie
 * Date: 2020/7/19
 *
 */
class HorizonRecycleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("wzt", "[HorizonRecycleView][dispatchTouchEvent] ev = ${MotionEvent.actionToString(ev!!.action)}")
        val result = super.dispatchTouchEvent(ev)
        Log.i("wzt", "[HorizonRecycleView][dispatchTouchEvent] return $result")
        return result
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        Log.i("wzt", "[HorizonRecycleView][onTouchEvent] e = = ${MotionEvent.actionToString(e!!.action)}")
        val result = super.onTouchEvent(e)
        Log.i("wzt", "[HorizonRecycleView][onTouchEvent] return $result")
        return result
    }

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        Log.i("wzt", "[HorizonRecycleView][onInterceptTouchEvent] e = = ${MotionEvent.actionToString(e!!.action)}")
        val result = super.onInterceptTouchEvent(e)
        Log.i("wzt", "[HorizonRecycleView][onInterceptTouchEvent] return $result")
        return result
    }
}