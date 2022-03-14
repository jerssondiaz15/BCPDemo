package com.example.data.coin.database.model.mapper

import com.example.data.coin.database.model.DbCoin
import com.example.domain.model.Coin
fun List<DbCoin>.toCoinList(): List<Coin> = this.map { it.toCoin() }
fun DbCoin.toCoin(): Coin = with(this){
    Coin(
        id = id,
        country = country,
        value = value,
        coin = coin,
        nom = nom
    )
}