package com.example.indonesiaterritoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.indonesiaterritoryapp.databinding.ActivityMainBinding
import com.example.indonesiaterritoryapp.domain.model.Province
import com.example.indonesiaterritoryapp.domain.model.Regency
import com.example.indonesiaterritoryapp.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private var listProvince = ArrayList<String>()
    private var listRegency = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleProvinces()
        observeProvince()
        observeRegencies()
    }

    private fun handleProvinces() {
        mainViewModel.getProvinces()
    }

    private fun handleRegencies(id: String) {
        val provinceId = "$id.json"
        mainViewModel.getRegencies(provinceId)
    }

    private fun observeProvince() {
        mainViewModel.resultProvince.observe(this@MainActivity) {
            addListProvince(it)
            handleSpinnerProvince(it)
        }
    }

    private fun addListProvince(data: List<Province>) {
        listProvince.clear()
        listProvince.add("Pilih Provinsi")
        data.forEach {
            listProvince.add(it.name)
        }
    }

    private fun handleSpinnerProvince(data: List<Province>) {
        binding.spinnerProvince.apply {
            setItems(listProvince)
            setOnItemSelectedListener { _, _, _, item ->
                if (item != "Pilih Provinsi") {
                    data.forEach {
                        if (item == it.name) {
                            handleRegencies(it.id)
                        }
                    }
                } else {
                    binding.spinnerRegency.visibility = View.GONE
                    listRegency.clear()
                }
            }
        }
    }

    private fun observeRegencies() {
        mainViewModel.resultRegency.observe(this@MainActivity) {
            addListRegency(it)
            handleSpinnerRegency()
        }
    }

    private fun addListRegency(data: List<Regency>) {
        listRegency.clear()
        listRegency.add("Pilih Kota/Kabupaten")
        data.forEach {
            listRegency.add(it.name)
        }
    }

    private fun handleSpinnerRegency() {
        binding.spinnerRegency.apply {
            visibility = View.VISIBLE
            setItems(listRegency)
        }
    }
}