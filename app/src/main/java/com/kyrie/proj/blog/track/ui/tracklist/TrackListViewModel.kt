package com.kyrie.proj.blog.track.ui.tracklist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kyrie.proj.blog.track.model.Product

class TrackListViewModel : ViewModel() {
    private val defaultProducts = listOf(
        Product(1, "商品1", 1),
        Product(2, "商品2", 2),
        Product(3, "商品3", 3),
        Product(4, "商品4", 4),
        Product(5, "商品5", 5),
        Product(6, "商品6", 6),
        Product(7, "商品7", 7),
        Product(8, "商品8", 8),
        Product(9, "商品9", 9),
        Product(10, "商品10", 10)
    )
    var productsLiveData: MutableLiveData<List<Product>> = MutableLiveData(defaultProducts)
}

