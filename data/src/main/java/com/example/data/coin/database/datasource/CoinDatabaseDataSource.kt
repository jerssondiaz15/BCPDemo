package com.example.data.coin.database.datasource

import com.example.data.coin.database.CoinDataBase
import com.example.data.coin.database.model.DbCoin
import kotlinx.coroutines.flow.Flow

class CoinDatabaseDataSource(
    private val database: CoinDataBase
) {
    fun getDbListCoin(): Flow<List<DbCoin>>{
        return database.coinDao().getDbListCoin()
    }
}