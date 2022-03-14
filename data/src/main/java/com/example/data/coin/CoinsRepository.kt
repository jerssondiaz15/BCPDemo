package com.example.data.coin

import com.example.data.coin.database.datasource.CoinDatabaseDataSource
import com.example.data.coin.database.model.mapper.toCoinList
import com.example.domain.model.Coin
import com.example.domain.repository.ICoinsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CoinsRepository @Inject constructor(
    private val coinDatabaseDataSource: CoinDatabaseDataSource
): ICoinsRepository {

    override fun getListCoins(): Flow<List<Coin>> {
        return coinDatabaseDataSource.getDbListCoin().map {
            it.toCoinList()
        }
    }

}