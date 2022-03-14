package com.example.bcpdemo.domain.usecase

import com.example.bcpdemo.domain.model.Coin
import com.example.bcpdemo.domain.repository.ICoinsRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val iCoinsRepository: ICoinsRepository
) {
    suspend operator fun invoke(): List<Coin>{
        return iCoinsRepository.getListCoins().map {
            it
        }
    }
}