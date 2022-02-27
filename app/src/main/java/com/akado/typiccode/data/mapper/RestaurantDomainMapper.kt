package com.akado.typiccode.data.mapper

import com.akado.typiccode.data.model.RestaurantData
import com.akado.typiccode.domain.model.RestaurantDomainModel

object RestaurantDomainMapper : DomainMapper<RestaurantData, RestaurantDomainModel> {

    override fun mapToModel(from: RestaurantData): RestaurantDomainModel {
        return RestaurantDomainModel(
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