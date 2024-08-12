package com.company.chatwiseassignment.ui.view

import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.company.chatwiseassignment.R
import com.company.chatwiseassignment.data.model.AdditionalInfoItem
import com.company.chatwiseassignment.data.model.Product
import com.company.chatwiseassignment.data.model.Review
import com.company.chatwiseassignment.databinding.ActivityProductDetailsBinding
import com.company.chatwiseassignment.ui.adapter.AdditionalInformationAdapter

class ProductDetailsActivity: AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding
    private lateinit var additinalInformationAdapter: AdditionalInformationAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val product = intent.getParcelableExtra<Product>("product")
        val context: Context = this
        var isExpanded: Boolean = false

        binding.brandNameTextView.text = product?.brand
        binding.ratingTextView.text = product?.rating.toString()
        binding.productTitleTextView.text = product?.title
        Glide.with(context).load(product?.thumbnail).into(binding.productImage)

        binding.productDescTextView.apply {
            text = product?.description
            setOnClickListener {
                if (isExpanded) {
                    animateTextView(this, 3)
                    ellipsize = TextUtils.TruncateAt.END
                    isExpanded = false
                } else {
                    animateTextView(this, Int.MAX_VALUE)
                    ellipsize = null
                    isExpanded = true
                }
            }
        }

        binding.stockTextView.text = "${product?.stock} left in Stock"
        binding.minOrderQuantityTextView.text = "Minimum Order Quantity: ${product?.minimumOrderQuantity}"
        binding.discountPercentageTextView.text = "-${product?.discountPercentage}"
        binding.priceTextView.text = "$${product?.price}"
        binding.tag1TextView.text = "${product?.tags?.get(0)}"
        binding.tag1TextView.text = "${product?.tags?.get(1)}"

        initRecyclerView(product!!)
        displayReviews(product.reviews)

    }

    private fun displayReviews(reviews: List<Review>?) {
        val parentLayout = binding.reviewsContainer
        reviews?.forEach {
            val reviewCard = layoutInflater.inflate(R.layout.review_card, parentLayout, false)

            val ratingCardView = reviewCard.findViewById<androidx.cardview.widget.CardView>(R.id.ratingCardView)
            val ratingTextView = ratingCardView.findViewById<TextView>(R.id.ratingTextView)
            val commentTextView = reviewCard.findViewById<TextView>(R.id.reviewCommentTextView)
            val nameTextView = reviewCard.findViewById<TextView>(R.id.reviewerNameTextView)
            val emailTextView = reviewCard.findViewById<TextView>(R.id.reviewerEmailTextView)
            val dateTextView = reviewCard.findViewById<TextView>(R.id.reviewDateTextView)

            ratingTextView.text = "${it.rating}"
            commentTextView.text = it.comment
            nameTextView.text = "${it.reviewerName}"
            emailTextView.text = it.reviewerEmail
            dateTextView.text = it.date?.substring(0, 10)


            parentLayout.addView(reviewCard)

        }

    }

    private fun initRecyclerView(product: Product) {
        val additionalInfoList = getAdditionalInfoList(product)
        additinalInformationAdapter = AdditionalInformationAdapter(additionalInfoList)
        binding.recyclerViewAdditionalInfo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewAdditionalInfo.adapter = additinalInformationAdapter
    }

    private fun getAdditionalInfoList(product: Product): List<AdditionalInfoItem> {
        return listOf(
            AdditionalInfoItem(product.category ?: "N/A", R.drawable.ic_category),
            AdditionalInfoItem("${product.weight} g", R.drawable.ic_weight),
            AdditionalInfoItem("${product.dimensions?.width} x ${product.dimensions?.height} x ${product.dimensions?.depth} cm", R.drawable.ic_dimensions),
            AdditionalInfoItem(product.warrantyInformation ?: "N/A", R.drawable.ic_warranty),
            AdditionalInfoItem(product.shippingInformation ?: "N/A", R.drawable.ic_shipping),
            AdditionalInfoItem(product.availabilityStatus ?: "N/A", R.drawable.ic_availability),
            AdditionalInfoItem(product.returnPolicy ?: "N/A", R.drawable.ic_return_policy)
        )
    }

    private fun animateTextView(textView: TextView, maxLines: Int) {
        val startHeight = textView.height

        textView.maxLines = maxLines
        textView.measure(
            View.MeasureSpec.makeMeasureSpec(textView.width, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        )
        val endHeight = textView.measuredHeight

        val animation = ValueAnimator.ofInt(startHeight, endHeight)
        animation.addUpdateListener { valueAnimator ->
            textView.height = valueAnimator.animatedValue as Int
        }
        animation.duration = 300
        animation.start()
    }
}

