package com.kyrie.proj.blog.vp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kyrie.proj.blog.R
import kotlinx.android.synthetic.main.activity_view_pager.*

/**
 * 学习ViewPager2使用
 */
class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        viewpager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return 3
            }

            override fun createFragment(position: Int): Fragment {
                return ViewPagerFragment()
            }

        }
        viewpager.isUserInputEnabled = false
    }
}