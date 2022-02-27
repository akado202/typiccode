package com.akado.typiccode.remote.mapper

import com.akado.typiccode.data.model.RestaurantData
import com.akado.typiccode.remote.model.RestaurantRemoteModel

object RestaurantRemoteMapper : RemoteMapper<RestaurantRemoteModel, RestaurantData> {

    override fun mapToData(from: RestaurantRemoteModel): RestaurantData {
        return RestaurantData(
            restaurantIdx = from.restaurantIdx,
            thumbnail = from.thumbnail,
            classification = from.classification,
            restaurantName = from.restaurantName,
            rating = from.rating,
            reviewCount = from.reviewCount,
            summaryAddress = from.summaryAddress,
            isQuickBooking = from.isQuickBooking,
            isRemoteWaiting = from.isRemoteWaiting,
            useWaiting = from.useWaiting,
            useBooking = from.useBooking,
            isNew = from.useBooking,
            waitingCount = from.waitingCount
        )
    }
}