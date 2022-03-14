package com.example.data.di

import android.content.Context
import com.example.data.coin.CoinsRepository
import com.example.data.coin.database.CoinDataBase
import com.example.data.coin.database.datasource.CoinDatabaseDataSource
import com.example.domain.repository.ICoinsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*@Module
@InstallIn(SingletonComponent::class)
object DataModule{

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        CoinDataBase::class.java,
        "CoinDatabase"
    ).build

    @Provides
    fun provideCoinRepository(
        coinsDatabaseDataSource: CoinDatabaseDataSource
    ): ICoinsRepository{
        return CoinsRepository(
            coinDatabaseDataSource = coinsDatabaseDataSource
        )
    }

    @Provides
    fun provideCoinDatabaseDataSource(
        coinDataBase: CoinDataBase
    ): CoinDatabaseDataSource{
        return CoinDatabaseDataSource(coinDataBase)
    }

}*/