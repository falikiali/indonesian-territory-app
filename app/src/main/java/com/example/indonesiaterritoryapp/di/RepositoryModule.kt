package com.example.indonesiaterritoryapp.di

import com.example.indonesiaterritoryapp.data.ImplIndonesianTerritoryRepository
import com.example.indonesiaterritoryapp.domain.repository.IndonesianTerritoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideIndonesianTerritoryRepository(indonesianTerritoryRepository: ImplIndonesianTerritoryRepository): IndonesianTerritoryRepository
}