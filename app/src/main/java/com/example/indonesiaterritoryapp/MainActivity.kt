package com.example.indonesiaterritoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.indonesiaterritoryapp.databinding.ActivityMainBinding
import com.example.indonesiaterritoryapp.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getProvinces()
        mainViewModel.getRegencies("11.json")

        mainViewModel.resultProvince.observe(this) {
            Log.d("MAIN ACTIVITY", it.toString())
        }

        mainViewModel.resultRegency.observe(this) {
            Log.d("TAG REGENCY", it.toString())
        }

        mainViewModel.error.observe(this@MainActivity) {
            Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_SHORT).show()
            Log.e("ERROR REGENCY", it.toString())
        }
    }
}