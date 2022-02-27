package com.akado.typiccode.ui.interest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akado.typiccode.domain.model.RestaurantDomainModel
import com.akado.typiccode.domain.usecase.RestaurantRecentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RecentInterestViewModel @Inject constructor(
    var useCase: RestaurantRecentUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _list = MutableLiveData<List<RestaurantDomainModel>>(Collections.emptyList())
    val list: LiveData<List<RestaurantDomainModel>> get() = _list

    init {
        useCase.fetch(0)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { _list.value = it }
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}