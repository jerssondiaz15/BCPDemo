package com.example.bcpdemo.data.di

import android.content.Context
import androidx.room.Room
import com.example.bcpdemo.data.coin.CoinsRepository
import com.example.bcpdemo.data.coin.database.CoinDataBase
import com.example.bcpdemo.data.coin.database.datasource.CoinDatabaseDataSource
import com.example.bcpdemo.domain.repository.ICoinsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule{

    private const val COIN_DATABASE_NAME = "coin_database"

    @Provides
    @Singleton
    fun provideCoinDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CoinDataBase::class.java,COIN_DATABASE_NAME)
            .createFromAsset("database/CoinDatabase.db")
            .build()

    @Singleton
    @Provides
    fun provideCoinDao(db: CoinDataBase) = db.coinDao()

    @Provides
    fun provideCoinRepository(
        coinDatabaseDataSource: CoinDatabaseDataSource
    ) : ICoinsRepository{
        return CoinsRepository(
            coinDatabaseDataSource = coinDatabaseDataSource
        )
    }

    @Provides
    fun provideDataSource(
        coinDataBase: CoinDataBase
    ): CoinDatabaseDataSource {
        return CoinDatabaseDataSource(coinDataBase)
    }
}