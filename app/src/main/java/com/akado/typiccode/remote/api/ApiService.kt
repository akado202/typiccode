package com.akado.typiccode.remote.api

import com.akado.typiccode.remote.model.response.RestaurantResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("save")
    fun getSave(): Single<RestaurantResponse>

    @GET("recent")
    fun getRecent(): Single<RestaurantResponse>
}