package com.akado.typiccode

import com.akado.typiccode.data.remote.RestaurantRemote
import com.akado.typiccode.di.ApiModule
import com.akado.typiccode.di.NetworkModule
import com.akado.typiccode.di.RemoteSourceModule
import com.akado.typiccode.remote.api.ApiService
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class RestaurantDataSourceUnitTest {

    private lateinit var retrofit: Retrofit
    private lateinit var apiService: ApiService
    private lateinit var restaurantDataSource: RestaurantRemote

    @Before
    fun setup() {
        retrofit = NetworkModule.provideRetrofit()
        apiService = ApiModule.provideApiService(retrofit)
        restaurantDataSource = RemoteSourceModule.provideRestaurantDataSource(apiService)
    }

    @Test
    fun testGetRecent() {
        println("testGetRecent")
        restaurantDataSource.getRecent()
            .doOnSuccess { println("output : $it") }
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertValue { it.isNotEmpty() }
            .assertComplete()
    }

    @Test
    fun testGetSave() {
        println("testGetSave")
        restaurantDataSource.getSave()
            .doOnSuccess { println("output : $it") }
            .test()
            .awaitDone(3000, TimeUnit.SECONDS)
            .assertValue { it.isNotEmpty() }
            .assertComplete()
    }
}