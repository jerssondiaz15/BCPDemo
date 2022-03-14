package com.example.bcpdemo.data.coin.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.bcpdemo.data.coin.database.model.DbCoin

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin")
    suspend fun getDbListCoin(): List<DbCoin>

}