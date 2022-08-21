package com.example.mvvmwithretrofitandroomapp

import android.app.Application
import com.example.mvvmwithretrofitandroomapp.api.QuoteService
import com.example.mvvmwithretrofitandroomapp.api.RetrofitHelper
import com.example.mvvmwithretrofitandroomapp.db.QuoteDatabase
import com.example.mvvmwithretrofitandroomapp.repository.QuoteRepository

class QuoteApplication: Application() {

    lateinit var quoteRepository: QuoteRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
         quoteRepository = QuoteRepository(quoteService,database,applicationContext)
    }
}