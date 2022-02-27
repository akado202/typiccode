package com.akado.typiccode.ui.interest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akado.typiccode.R
import com.akado.typiccode.domain.model.RestaurantDomainModel
import com.bumptech.glide.Glide

class RestaurantAdapter : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    private var items: List<RestaurantDomainModel> = listOf()

    fun setItems(items: List<RestaurantDomainModel>) {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_restaurant_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val iv_thumbnail = itemView.findViewById<ImageView>(R.id.iv_thumbnail)

        fun bind(model: RestaurantDomainModel) {
            Glide.with(itemView)
                .load(model.thumbnail)
                .centerCrop()
                .into(iv_thumbnail)
        }
    }

}

object RestaurantBindingConverter {

    @BindingAdapter("restaurantAdapter")
    @JvmStatic
    fun setRestaurantAdapter(
        recyclerView: RecyclerView,
        set:Boolean
    ) {
        recyclerView.adapter = if (set) RestaurantAdapter() else null
    }

    @BindingAdapter("restaurantItems")
    @JvmStatic
    fun setRestaurantItems(
        recyclerView: RecyclerView,
        items: List<RestaurantDomainModel>?
    ) {
        if (recyclerView.adapter is RestaurantAdapter) {
            val adapter = recyclerView.adapter as RestaurantAdapter
            adapter.setItems(items ?: listOf())
            adapter.notifyDataSetChanged()
        }
    }
}