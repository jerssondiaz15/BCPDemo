package com.example.bcpdemo.data.coin.database.datasource

import com.example.bcpdemo.data.coin.database.CoinDataBase
import com.example.bcpdemo.data.coin.database.model.DbCoin

class CoinDatabaseDataSource(
    private val coinDataBase: CoinDataBase
) {
    suspend fun getListCoins(): List<DbCoin> {
        val response = coinDataBase.coinDao().getDbListCoin()
        return response.map { it }
    }
}