package com.example.mvvmwithretrofitandroomapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithretrofitandroomapp.repository.QuoteRepository

class MainViewModelFactory(private val repository: QuoteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}