package com.example.domain.usecase

import com.example.domain.repository.ICoinsRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val coinsRepository: ICoinsRepository) {

    suspend operator fun invoke() = coinsRepository.getListCoins()
}