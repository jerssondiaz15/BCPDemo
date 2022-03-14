package com.example.bcpdemo.domain.model

data class Coin(
    var id: Int,
    var country: String,
    var value: Double,
    var coin: String,
    var nom: String
)

data class BuySell(
    var buy: Double = 0.0,
    var sell: Double = 0.0
)