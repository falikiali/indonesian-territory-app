package com.example.indonesiaterritoryapp.domain.usecase

import com.example.indonesiaterritoryapp.domain.model.Province
import com.example.indonesiaterritoryapp.domain.model.Regency
import com.example.indonesiaterritoryapp.domain.repository.IndonesianTerritoryRepository
import com.example.indonesiaterritoryapp.utils.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImplIndonesianTerritoryUseCase @Inject constructor(private val indonesianTerritoryRepository: IndonesianTerritoryRepository): IndonesianTerritoryUseCase {
    override suspend fun getProvinces(): Flow<ResultState<List<Province>>> {
        return indonesianTerritoryRepository.getProvinces()
    }

    override suspend fun getRegencies(provinceId: String): Flow<ResultState<List<Regency>>> {
        return indonesianTerritoryRepository.getRegencies(provinceId)
    }

}