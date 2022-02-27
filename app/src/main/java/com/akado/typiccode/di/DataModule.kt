package com.akado.typiccode.di

import com.akado.typiccode.data.remote.RestaurantRemote
import com.akado.typiccode.data.repository.RestaurantRepositoryImpl
import com.akado.typiccode.domain.repository.RestaurantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideMovieRepository(dataSource: RestaurantRemote): RestaurantRepository {
        return RestaurantRepositoryImpl(dataSource)
    }
}