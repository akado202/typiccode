package com.akado.typiccode.data.model

data class RestaurantData(
    val restaurantIdx: Int,
    val thumbnail: String,
    val classification: String,
    val restaurantName: String,
    val rating: Float,
    val reviewCount: Int,
    val summaryAddress: String,
    val isQuickBooking: Boolean,
    val isRemoteWaiting: Boolean,
    val useWaiting: Boolean,
    val useBooking: Boolean,
    val isNew: Boolean,
    val waitingCount: Int
)