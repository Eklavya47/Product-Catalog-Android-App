package com.company.chatwiseassignment.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.chatwiseassignment.databinding.ProductlistRecyclerviewBinding
import com.company.chatwiseassignment.ui.adapter.ProductAdapter
import com.company.chatwiseassignment.ui.viewmodel.ProductListActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListActivity: AppCompatActivity() {
    private lateinit var binding: ProductlistRecyclerviewBinding
    private val productViewModel: ProductListActivityViewModel by viewModels()
    private lateinit var productAdapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductlistRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        getProductsFromInternet()
        productViewModel.productList.observe(this){
            it.let {
                productAdapter.updateProducts(it)
            }
        }

        productViewModel.isLoading.observe(this) {
            binding.progressCircular.isVisible = it
        }

    }

    private fun getProductsFromInternet() {
        productViewModel.getProducts()
    }

    private fun initRecyclerView() {
        productAdapter = ProductAdapter(arrayListOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = productAdapter
    }
}

