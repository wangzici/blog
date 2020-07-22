package com.kyrie.proj.blog.textview

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView
import java.util.*

/**
 * Created by wzt on 2020/7/22
 * 添加滚动监听
 */
class MyScrollView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ScrollView(context, attrs, defStyleAttr) {
    private var millis: Long = 0

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        if (mListeners.isEmpty()) {
            return
        }
        for (listener in mListeners) {
            listener.onScrollChanged(l, t, oldl, oldt)
        }
        val now = System.currentTimeMillis()
        if (now - millis > 1000L) {
            if (this.height + oldt < this.computeVerticalScrollRange()
                && this.height + t >= this.computeVerticalScrollRange()
            ) {
                for (listener in mListeners) {
                    listener.onScrollBottom()
                    millis = now
                }
            }
        }
    }

    private val mListeners: MutableList<OnScrollChangeListener> =
        ArrayList()

    fun addOnScrollChangeListener(listener: OnScrollChangeListener) {
        if (!mListeners.contains(listener)) {
            mListeners.add(listener)
        }
    }

    interface OnScrollChangeListener {
        fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int)
        fun onScrollBottom()
    }
}