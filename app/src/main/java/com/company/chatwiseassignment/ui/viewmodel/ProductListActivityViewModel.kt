package com.company.chatwiseassignment.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.chatwiseassignment.data.model.Product
import com.company.chatwiseassignment.domain.usecases.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListActivityViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase
): ViewModel() {
    val productList = MutableLiveData<ArrayList<Product>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getProducts(){
        isLoading.postValue(true)
        viewModelScope.launch {
            val products = getProductUseCase.invoke()
            Log.d("ProductListActivity", "Fetched products: $products")
            if (products != null){
                productList.postValue(products)
                isLoading.postValue(false)
            }
        }
    }
}