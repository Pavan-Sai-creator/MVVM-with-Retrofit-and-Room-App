package com.example.mvvmwithretrofitandroomapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmwithretrofitandroomapp.api.QuoteService
import com.example.mvvmwithretrofitandroomapp.db.QuoteDatabase
import com.example.mvvmwithretrofitandroomapp.models.QuoteList
import com.example.mvvmwithretrofitandroomapp.utils.NetworkUtils

class QuoteRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
    get() = quotesLiveData

    suspend fun getQuotes(page: Int){
        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quoteService.getQuotes(page)
            if(result!=null && result.body()!=null)
            {
                quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                quotesLiveData.postValue(result.body())
            }
        }else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1,1,1,quotes,1,1)
            quotesLiveData.postValue(quoteList)
        }




    }
}