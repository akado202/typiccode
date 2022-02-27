package com.akado.typiccode.ui.interest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.akado.typiccode.R
import com.akado.typiccode.databinding.ViewRestaurantRowBinding
import com.akado.typiccode.domain.model.RestaurantDomainModel
import com.bumptech.glide.Glide

class RestaurantAdapter : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    private var items: List<RestaurantDomainModel> = listOf()

    fun updateItems(items: List<RestaurantDomainModel>) {
        // TODO: diffUtil code here

        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ViewRestaurantRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.binding.vAction.setOnClickListener{ }
    }

    class ViewHolder(val binding: ViewRestaurantRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: RestaurantDomainModel) {
            binding.viewModel = model
        }
    }
}

object RestaurantBindingConverter {

    @BindingAdapter("restaurantAdapter")
    @JvmStatic
    fun setRestaurantAdapter(
        recyclerView: RecyclerView,
        set: Boolean
    ) {
        recyclerView.adapter = if (set) RestaurantAdapter() else null
    }

    @BindingAdapter("restaurantItems")
    @JvmStatic
    fun setRestaurantItems(
        recyclerView: RecyclerView,
        items: List<RestaurantDomainModel>?
    ) {
        val adapter = recyclerView.adapter as RestaurantAdapter
        adapter.let {
            it.updateItems(items ?: listOf())

            // TODO: diffUtil 로 code 교체
            it.notifyDataSetChanged()
        }
    }

    @BindingAdapter("restaurantThumbnail")
    @JvmStatic
    fun setRestaurantThumbnail(imageView: ImageView, url: String) {
        Glide.with(imageView)
            .load(url)
            .centerCrop()
            .into(imageView)
    }

    @SuppressLint("SetTextI18n")
    @BindingAdapter("restaurantReviewCount")
    @JvmStatic
    fun setRestaurantReviewCount(textView: TextView, count: Int) {
        textView.text = if (count > 300) "(300+)" else "($count)"
    }
}