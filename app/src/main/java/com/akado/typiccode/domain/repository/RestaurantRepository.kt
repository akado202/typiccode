package com.akado.typiccode.domain.repository

import com.akado.typiccode.domain.model.RestaurantDomainModel
import io.reactivex.Single

interface RestaurantRepository {

    fun getSave(): Single<List<RestaurantDomainModel>>

    fun getRecent(): Single<List<RestaurantDomainModel>>
}