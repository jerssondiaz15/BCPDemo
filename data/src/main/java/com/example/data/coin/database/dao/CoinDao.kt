package com.example.data.coin.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.data.coin.database.model.DbCoin
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin")
    fun getDbListCoin(): Flow<List<DbCoin>>

}