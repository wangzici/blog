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
        Log.i("kyrie", "[HorizonRecycleView][dispatchTouchEvent] ev = $ev")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        Log.i("kyrie", "[HorizonRecycleView][onTouchEvent] e = $e")
        return super.onTouchEvent(e)
    }

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        Log.i("kyrie", "[HorizonRecycleView][onInterceptTouchEvent] e = $e")
        return super.onInterceptTouchEvent(e)
    }
}