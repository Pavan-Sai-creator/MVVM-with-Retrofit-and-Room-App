package com.example.mvvmwithretrofitandroomapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmwithretrofitandroomapp.models.Result

@Dao
interface QuoteDAO {
    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("SELECT * FROM quote")
    fun getQuotes(): List<Result>
}