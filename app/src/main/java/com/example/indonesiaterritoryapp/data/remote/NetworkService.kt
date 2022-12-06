package com.example.indonesiaterritoryapp.data.remote

import com.example.indonesiaterritoryapp.data.responses.ProvinceResponseItem
import com.example.indonesiaterritoryapp.data.responses.RegencyResponseItem
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {
    /**
     * Endpoints Provinsi
     */
    @GET("provinces.json")
    suspend fun getProvinces(): List<ProvinceResponseItem>

    /**
     * Endpoints Kota/Kabupaten
     */
    @GET("regencies/{province}")
    suspend fun getRegencies(
        @Path("province") province: String
    ): List<RegencyResponseItem>
}