package com.example.indonesiaterritoryapp.utils

import com.example.indonesiaterritoryapp.data.responses.ProvinceResponseItem
import com.example.indonesiaterritoryapp.data.responses.RegencyResponseItem
import com.example.indonesiaterritoryapp.domain.model.Province
import com.example.indonesiaterritoryapp.domain.model.Regency

object Mapper {
    fun mapProvinceResponseToDomain(data: List<ProvinceResponseItem>): List<Province> {
        return data.map {
            Province(
                it.name,
                it.id
            )
        }
    }

    fun mapRegencyResponseToDomain(data: List<RegencyResponseItem>): List<Regency> {
        return data.map {
            Regency(
                it.provinceId,
                it.name,
                it.id
            )
        }
    }
}