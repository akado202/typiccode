package com.akado.typiccode.data.repository

import com.akado.typiccode.data.mapper.RestaurantDomainMapper
import com.akado.typiccode.data.remote.RestaurantRemote
import com.akado.typiccode.domain.model.RestaurantDomainModel
import com.akado.typiccode.domain.repository.RestaurantRepository
import io.reactivex.Single
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor (
    private val dataSource: RestaurantRemote
) : RestaurantRepository {

    override fun getSave(): Single<List<RestaurantDomainModel>> {
        return dataSource.getSave()
            .map { it.map(RestaurantDomainMapper::mapToModel) }

    }

    override fun getRecent(): Single<List<RestaurantDomainModel>> {
        return dataSource.getSave()
            .map { it.map(RestaurantDomainMapper::mapToModel) }
    }
}