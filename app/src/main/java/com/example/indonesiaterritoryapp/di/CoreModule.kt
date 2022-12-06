package com.example.indonesiaterritoryapp.di

import com.example.indonesiaterritoryapp.data.remote.Network
import com.example.indonesiaterritoryapp.data.remote.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {
    @Provides
    fun provideNetworkService(): NetworkService {
        return Network.retrofitClient().create(NetworkService::class.java)
    }
}