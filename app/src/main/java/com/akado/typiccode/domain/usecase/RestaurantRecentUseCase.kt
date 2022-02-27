package com.akado.typiccode.domain.usecase

import com.akado.typiccode.domain.model.RestaurantDomainModel
import com.akado.typiccode.domain.repository.RestaurantRepository
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RestaurantRecentUseCase  @Inject constructor (
    private val repository: RestaurantRepository
) : UseCase<Flowable<List<RestaurantDomainModel>>, Any?> {

    override fun fetch(param: Any?): Flowable<List<RestaurantDomainModel>> {
        return repository.getRecent()
            .toFlowable()
            .subscribeOn(Schedulers.io())
    }
}