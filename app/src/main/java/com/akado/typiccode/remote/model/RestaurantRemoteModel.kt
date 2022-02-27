package com.akado.typiccode.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RestaurantRemoteModel(
    @SerializedName("restaurantIdx")
    @Expose
    val restaurantIdx: Int,

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String,

    @SerializedName("classification")
    @Expose
    val classification: String,

    @SerializedName("restaurantName")
    @Expose
    val restaurantName: String,

    @SerializedName("rating")
    @Expose
    val rating: Float,

    @SerializedName("reviewCount")
    @Expose
    val reviewCount: Int,

    @SerializedName("summaryAddress")
    @Expose
    val summaryAddress: String,

    @SerializedName("isQuickBooking")
    @Expose
    val isQuickBooking: Boolean,

    @SerializedName("isRemoteWaiting")
    @Expose
    val isRemoteWaiting: Boolean,

    @SerializedName("useWaiting")
    @Expose
    val useWaiting: Boolean,

    @SerializedName("useBooking")
    @Expose
    val useBooking: Boolean,

    @SerializedName("isNew")
    @Expose
    val isNew: Boolean,

    @SerializedName("waitingCount")
    @Expose
    val waitingCount: Int
)