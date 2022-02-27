package com.akado.typiccode.data.remote

import com.akado.typiccode.data.model.RestaurantData
import io.reactivex.Single

interface RestaurantRemote {

    fun getSave(): Single<List<RestaurantData>>

    fun getRecent(): Single<List<RestaurantData>>
}