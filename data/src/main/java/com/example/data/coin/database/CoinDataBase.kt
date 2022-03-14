package com.example.data.coin.database

import android.content.Context
import androidx.room.Database
import com.example.data.coin.database.dao.CoinDao
import com.example.data.coin.database.model.DbCoin

@Database(
    entities = [
        DbCoin::class
    ],
    version = 1,
    exportSchema = true
)
abstract class CoinDataBase: RoomDatabase() {
    abstract fun coinDao(): CoinDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}