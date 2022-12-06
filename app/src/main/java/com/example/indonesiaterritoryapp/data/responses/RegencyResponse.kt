package com.example.indonesiaterritoryapp.data.responses

import com.google.gson.annotations.SerializedName

data class RegencyResponseItem(
	@SerializedName("province_id")
	val provinceId: String,
	val name: String,
	val id: String
)

