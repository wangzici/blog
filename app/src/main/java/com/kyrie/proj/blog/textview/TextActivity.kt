package com.kyrie.proj.blog.textview

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.kyrie.proj.blog.R
import com.kyrie.proj.blog.util.FileUtils
import kotlinx.android.synthetic.main.activity_text.*

/**
 * Created by wzt on 2020/7/22
 * 加载超长文本的TextView
 */
class TextActivity : Activity() {
    private val FILE_DEFAULT = "诗经24.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        val content = FileUtils.getTextFromAsset(this, FILE_DEFAULT)
        content?.let {
            showContent(it)
        }
    }

    private fun showLoading() {
        tv_long_text.visibility = View.GONE
        text_progress.visibility = View.VISIBLE
    }

    private fun showContent(content: String) {
        tv_long_text.text = content
        tv_long_text.visibility = View.VISIBLE
        text_progress.visibility = View.GONE
    }
}