package com.kyrie.proj.blog.track.ui.tracklist

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlin.math.max

/**
 * Created by wzt on 2020/9/7
 * 上报页面阅读进度基类
 */
abstract class TrackFragment : Fragment() {
    companion object{
        const val TAG = "TrackFragment"
    }

    //浏览数据集合的大小
    private var infoSize = 0

    //浏览的位置的最大值
    private var curMaxNum = 0

    override fun onPause() {
        super.onPause()
        postShowPercent()
    }

    /**
     * 设置数据总大小
     * @param infoSize 数据总大小
     */
    fun setInfoSize(infoSize: Int) {
        this.infoSize = infoSize
    }

    /**
     * 设置阅读进度最大值
     * @param curNum 当前阅读进度
     */
    fun setCurNum(curNum: Int) {
        curMaxNum = max(curNum, curMaxNum)
    }

    /**
     * 得到阅读进度
     * @return 阅读进度，从0~1的分数
     */
    private fun getProgressRate(): Float {
        return if (infoSize != 0) {
            curMaxNum.toFloat() / infoSize
        } else 0f
    }

    /**
     * 上报阅读进度
     */
    private fun postShowPercent() {
        val progressRate = getProgressRate()
        if (progressRate == 0f) {
            return
        }
        //在此处上报界面阅读进度
        Toast.makeText(context, "阅读进度为$progressRate", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "postShowPercent: 阅读进度为$progressRate")
    }
}