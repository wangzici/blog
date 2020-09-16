package com.kyrie.proj.blog.vp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kyrie.proj.blog.R

/**
 * Created by Kyrie
 * Date: 2020/9/17
 * ViewPager2内的子Fragment
 */
class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View?) {
        view?.apply {
            val recyclerView = findViewById<RecyclerView>(R.id.rv_vp)
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = SimpleAdapter(context)
        }
    }

}