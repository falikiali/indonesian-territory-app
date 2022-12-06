package com.example.indonesiaterritoryapp.utils

sealed class LoaderState {
    object ShowLoading: LoaderState()
    object HideLoading: LoaderState()
}
