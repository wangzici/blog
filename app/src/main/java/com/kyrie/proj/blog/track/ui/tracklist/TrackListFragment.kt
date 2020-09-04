package com.kyrie.proj.blog.track.ui.tracklist

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kyrie.proj.blog.R
import com.kyrie.proj.blog.track.adapter.ProductAdapter
import com.kyrie.proj.blog.track.model.Product
import kotlinx.android.synthetic.main.track_list_fragment.*

class TrackListFragment : Fragment() {
    private val list: MutableList<Product> = mutableListOf()

    companion object {
        fun newInstance() = TrackListFragment()
    }

    private lateinit var viewModel: TrackListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.track_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_track.adapter = ProductAdapter(context!!, list)
        rv_track.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        rv_track.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.right = 20
            }
        })
        rv_track.setOnClickListener {  }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TrackListViewModel::class.java)
        viewModel.productsLiveData.observe(viewLifecycleOwner,
            Observer {
                list.clear()
                list.addAll(it)
                rv_track.adapter!!.notifyDataSetChanged()
            })
    }

}