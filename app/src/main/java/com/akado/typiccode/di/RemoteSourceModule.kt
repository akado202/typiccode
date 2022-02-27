package com.akado.typiccode.di

import com.akado.typiccode.data.remote.RestaurantRemote
import com.akado.typiccode.remote.api.ApiService
import com.akado.typiccode.remote.source.RestaurantDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteSourceModule {

    @Provides
    @Singleton
    fun provideRestaurantDataSource(service: ApiService): RestaurantRemote {
        return RestaurantDataSource(service)
    }
}