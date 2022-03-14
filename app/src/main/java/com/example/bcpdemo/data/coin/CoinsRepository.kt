package com.example.bcpdemo.data.coin

import com.example.bcpdemo.data.coin.database.datasource.CoinDatabaseDataSource
import com.example.bcpdemo.domain.model.Coin
import com.example.bcpdemo.domain.repository.ICoinsRepository
import com.example.bcpdemo.data.coin.database.model.mapper.toCoin
import javax.inject.Inject

class CoinsRepository @Inject constructor (
    private val coinDatabaseDataSource: CoinDatabaseDataSource,
): ICoinsRepository{
    override suspend fun getListCoins(): List<Coin> {
        return coinDatabaseDataSource.getListCoins().map {
            it.toCoin()
        }
    }

}