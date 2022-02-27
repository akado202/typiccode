package com.akado.typiccode.di

import com.akado.typiccode.domain.repository.RestaurantRepository
import com.akado.typiccode.domain.usecase.RestaurantRecentUseCase
import com.akado.typiccode.domain.usecase.RestaurantSaveUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideRestaurantSaveUseCase(repository: RestaurantRepository): RestaurantSaveUseCase {
        return RestaurantSaveUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideRestaurantRecentUseCase(repository: RestaurantRepository): RestaurantRecentUseCase {
        return RestaurantRecentUseCase(repository)
    }
}