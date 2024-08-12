package com.company.chatwiseassignment.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.company.chatwiseassignment.R
import com.company.chatwiseassignment.data.model.Product
import com.company.chatwiseassignment.ui.view.ProductDetailsActivity

class ProductAdapter(private val productList: ArrayList<Product>): RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(layoutInflater.inflate(R.layout.productlist_item,parent,false))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct = productList[position]
        holder.render(currentProduct, holder.itemView.context)
        holder.itemView.setOnClickListener {
            goToProduct(
                currentProduct, holder.itemView.context
            )
        }
    }

    private fun goToProduct(product: Product, context: Context) {
        val intent = Intent(context, ProductDetailsActivity::class.java)
        intent.putExtra("product",product)
        context.startActivity(intent)
    }
    fun updateProducts(newProducts: ArrayList<Product>) {
        productList.clear()
        productList.addAll(newProducts)
        notifyDataSetChanged()
    }

}