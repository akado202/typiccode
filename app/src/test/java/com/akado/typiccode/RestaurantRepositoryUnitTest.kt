package com.akado.typiccode

import com.akado.typiccode.data.remote.RestaurantRemote
import com.akado.typiccode.di.ApiModule
import com.akado.typiccode.di.DataModule
import com.akado.typiccode.di.NetworkModule
import com.akado.typiccode.di.RemoteSourceModule
import com.akado.typiccode.domain.repository.RestaurantRepository
import com.akado.typiccode.remote.api.ApiService
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class RestaurantRepositoryUnitTest {

    private lateinit var retrofit: Retrofit
    private lateinit var apiService: ApiService
    private lateinit var restaurantDataSource: RestaurantRemote
    private lateinit var repository: RestaurantRepository

    @Before
    fun setup() {
        retrofit = NetworkModule.provideRetrofit()
        apiService = ApiModule.provideApiService(retrofit)
        restaurantDataSource = RemoteSourceModule.provideRestaurantDataSource(apiService)
        repository = DataModule.provideMovieRepository(restaurantDataSource)
    }

    @Test
    fun testGetRecent() {
        println("testGetRecent")
        repository.getRecent()
            .doOnSuccess { println("output : $it") }
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertValue { it.isNotEmpty() }
            .assertComplete()
    }

    @Test
    fun testGetSave() {
        println("testGetSave")
        repository.getSave()
            .doOnSuccess { println("output : $it") }
            .test()
            .awaitDone(3000, TimeUnit.SECONDS)
            .assertValue { it.isNotEmpty() }
            .assertComplete()
    }
}