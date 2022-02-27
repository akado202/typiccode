package com.akado.typiccode.remote.source

import com.akado.typiccode.data.model.RestaurantData
import com.akado.typiccode.data.remote.RestaurantRemote
import com.akado.typiccode.remote.api.ApiService
import com.akado.typiccode.remote.mapper.RestaurantRemoteMapper
import io.reactivex.Single
import javax.inject.Inject

class RestaurantDataSource @Inject constructor(
    private val service: ApiService
) : RestaurantRemote {

    override fun getSave(): Single<List<RestaurantData>> {
        return service.getSave()
            .map { it.list.map(RestaurantRemoteMapper::mapToData) }
    }

    override fun getRecent(): Single<List<RestaurantData>> {
        return service.getSave()
            .map { it.list.map(RestaurantRemoteMapper::mapToData) }
    }
}