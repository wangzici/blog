package com.kyrie.proj.blog.measure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kyrie.proj.blog.R

/**
 * 查看若父View为wrap_content，子View为match_parent会如何判断
 */
class MeasureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }
}