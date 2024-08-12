package com.company.chatwiseassignment.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.company.chatwiseassignment.data.model.AdditionalInfoItem
import com.company.chatwiseassignment.databinding.AdditinalInformationListBinding

class AdditionalInformationViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = AdditinalInformationListBinding.bind(view)

    fun render(item: AdditionalInfoItem){
        binding.additionalInfoImage.setImageResource(item.iconResId)
        binding.additionalInfoText.text = item.text
    }
}
