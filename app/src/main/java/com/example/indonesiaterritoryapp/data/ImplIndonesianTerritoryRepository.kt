package com.example.indonesiaterritoryapp.data

import com.example.indonesiaterritoryapp.data.remote.NetworkService
import com.example.indonesiaterritoryapp.domain.model.Province
import com.example.indonesiaterritoryapp.domain.model.Regency
import com.example.indonesiaterritoryapp.domain.repository.IndonesianTerritoryRepository
import com.example.indonesiaterritoryapp.utils.Mapper
import com.example.indonesiaterritoryapp.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImplIndonesianTerritoryRepository @Inject constructor(private val networkService: NetworkService): IndonesianTerritoryRepository {
    override suspend fun getProvinces(): Flow<ResultState<List<Province>>> {
        return flow {
            try {
                val response = networkService.getProvinces()
                val dataMapped = Mapper.mapProvinceResponseToDomain(response)
                emit(ResultState.Success(dataMapped))
            } catch (e: Exception) {
                emit(ResultState.Failed(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getRegencies(provinceId: String): Flow<ResultState<List<Regency>>> {
        return flow {
            try {
                val response = networkService.getRegencies(provinceId)
                if (response.isNotEmpty()) {
                    val dataMapped = Mapper.mapRegencyResponseToDomain(response)
                    emit(ResultState.Success(dataMapped))
                }
            } catch (e: Exception) {
                emit(ResultState.Failed(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}