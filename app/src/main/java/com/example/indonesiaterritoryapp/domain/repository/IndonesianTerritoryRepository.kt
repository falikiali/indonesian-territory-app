package com.example.indonesiaterritoryapp.domain.repository

import com.example.indonesiaterritoryapp.domain.model.Province
import com.example.indonesiaterritoryapp.domain.model.Regency
import com.example.indonesiaterritoryapp.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface IndonesianTerritoryRepository {
    /**
     * Remote
     */
    suspend fun getProvinces(): Flow<ResultState<List<Province>>>
    suspend fun getRegencies(provinceId: String): Flow<ResultState<List<Regency>>>
}