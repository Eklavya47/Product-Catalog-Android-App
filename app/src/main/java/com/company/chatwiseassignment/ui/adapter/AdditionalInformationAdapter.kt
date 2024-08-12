package com.company.chatwiseassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.company.chatwiseassignment.R
import com.company.chatwiseassignment.data.model.AdditionalInfoItem

class AdditionalInformationAdapter(private val items: List<AdditionalInfoItem>): RecyclerView.Adapter<AdditionalInformationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdditionalInformationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AdditionalInformationViewHolder(layoutInflater.inflate(R.layout.additinal_information_list,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AdditionalInformationViewHolder, position: Int) {
        val currentItem = items[position]
        holder.render(currentItem)
    }
}