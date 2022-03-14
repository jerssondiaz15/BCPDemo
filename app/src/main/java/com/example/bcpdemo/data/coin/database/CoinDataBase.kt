package com.example.bcpdemo.data.coin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bcpdemo.data.coin.database.dao.CoinDao
import com.example.bcpdemo.data.coin.database.model.DbCoin

@Database(
    entities = [
        DbCoin::class
    ],
    version = 1,
    exportSchema = true
)
abstract class CoinDataBase: RoomDatabase() {
    abstract fun coinDao(): CoinDao
}