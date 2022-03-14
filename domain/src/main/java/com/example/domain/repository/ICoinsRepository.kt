package com.example.domain.repository

import com.example.domain.model.Coin
import kotlinx.coroutines.flow.Flow

interface ICoinsRepository {

    fun getListCoins(): Flow<List<Coin>>

}