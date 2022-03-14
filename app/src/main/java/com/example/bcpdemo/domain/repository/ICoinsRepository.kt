package com.example.bcpdemo.domain.repository

import com.example.bcpdemo.domain.model.Coin

interface ICoinsRepository {

    suspend fun getListCoins(): List<Coin>

}