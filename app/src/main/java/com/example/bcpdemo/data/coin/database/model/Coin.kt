package com.example.bcpdemo.data.coin.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "coin"
)
data class DbCoin(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "value") val value: Double,
    @ColumnInfo(name = "coin") val coin: String,
    @ColumnInfo(name = "nom") val nom: String
)