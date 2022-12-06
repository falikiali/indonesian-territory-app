package com.example.indonesiaterritoryapp.di

import com.example.indonesiaterritoryapp.domain.usecase.ImplIndonesianTerritoryUseCase
import com.example.indonesiaterritoryapp.domain.usecase.IndonesianTerritoryUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideIndonesianTerritoryUseCase(implIndonesianTerritoryUseCase: ImplIndonesianTerritoryUseCase): IndonesianTerritoryUseCase
}