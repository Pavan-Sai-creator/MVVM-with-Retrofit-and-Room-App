package com.example.mvvmwithretrofitandroomapp

// https://www.youtube.com/watch?v=Dv-Dv4SusQo&list=PLRKyZvuMYSIO0jLgj8g6sADnD0IBaWaw2&index=19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithretrofitandroomapp.api.QuoteService
import com.example.mvvmwithretrofitandroomapp.api.RetrofitHelper
import com.example.mvvmwithretrofitandroomapp.repository.QuoteRepository
import com.example.mvvmwithretrofitandroomapp.viewmodels.MainViewModel
import com.example.mvvmwithretrofitandroomapp.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Log.d("Test",it.results.toString())
            Toast.makeText(this,it.results.size.toString(),Toast.LENGTH_LONG).show()
        })
    }
}