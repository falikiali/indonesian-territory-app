package com.example.indonesiaterritoryapp.utils

sealed class ResultState<out T: Any> {
    data class Success<out T: Any>(val data: T): ResultState<T>()
    data class Failed(val error: String): ResultState<Nothing>()
}
