package com.company.chatwiseassignment.ui.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.company.chatwiseassignment.data.model.Product
import com.company.chatwiseassignment.databinding.ProductlistItemBinding


class ProductViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ProductlistItemBinding.bind(view)

    fun render(product: Product, context: Context) {
        Glide.with(context).load(product.thumbnail).into(binding.imageView)
        binding.idTextView.text = "Product ${product.id}"
        binding.titleTextView.text = "${product.title}"
    }

}
