package com.example.indonesiaterritoryapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indonesiaterritoryapp.domain.model.Province
import com.example.indonesiaterritoryapp.domain.model.Regency
import com.example.indonesiaterritoryapp.domain.usecase.IndonesianTerritoryUseCase
import com.example.indonesiaterritoryapp.utils.LoaderState
import com.example.indonesiaterritoryapp.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

interface MainViewModelContract {
    fun getProvinces()
    fun getRegencies(provinceId: String)
}

@HiltViewModel
class MainViewModel @Inject constructor(private val indonesianTerritoryUseCase: IndonesianTerritoryUseCase): ViewModel(), MainViewModelContract {
    private val _state = MutableLiveData<LoaderState>()
    val state: LiveData<LoaderState> get() = _state

    private val _resultProvince = MutableLiveData<List<Province>>()
    val resultProvince: LiveData<List<Province>> get() = _resultProvince

    private val _resultRegency = MutableLiveData<List<Regency>>()
    val resultRegency: LiveData<List<Regency>> get() = _resultRegency

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    override fun getProvinces() {
        _state.value = LoaderState.ShowLoading
        viewModelScope.launch {
            indonesianTerritoryUseCase.getProvinces().collect {
                when(it) {
                    is ResultState.Success -> {
                        _state.value = LoaderState.HideLoading
                        _resultProvince.postValue(it.data)
                    }
                    is ResultState.Failed -> {
                        _state.value = LoaderState.HideLoading
                        _error.postValue(it.error)
                    }
                }
            }
        }
    }

    override fun getRegencies(provinceId: String) {
        _state.value = LoaderState.ShowLoading
        viewModelScope.launch {
            indonesianTerritoryUseCase.getRegencies(provinceId).collect {
                when(it) {
                    is ResultState.Success -> {
                        _state.value = LoaderState.HideLoading
                        _resultRegency.postValue(it.data)
                    }
                    is ResultState.Failed -> {
                        _state.value = LoaderState.HideLoading
                        _error.postValue(it.error)
                    }
                }
            }
        }
    }
}