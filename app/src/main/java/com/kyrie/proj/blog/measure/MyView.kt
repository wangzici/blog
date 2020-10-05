package com.kyrie.proj.blog.measure

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.View.MeasureSpec.*

class MyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object {
        private const val TAG = "MyView"
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val mode = MeasureSpec.getMode(widthMeasureSpec)
        val size = MeasureSpec.getSize(widthMeasureSpec)
        Log.i(Companion.TAG, "onMeasure: AT_MOST=$AT_MOST,EXACTLY=$EXACTLY,UNSPECIFIED=$UNSPECIFIED")
        Log.i(Companion.TAG, "onMeasure: mode = $mode,size = $size")
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}