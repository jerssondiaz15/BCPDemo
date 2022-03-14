package com.example.bcpdemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcpdemo.domain.model.BuySell
import com.example.bcpdemo.domain.model.Coin
import com.example.bcpdemo.domain.usecase.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.pow
import kotlin.math.roundToInt

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel(){

    private val _coinOrigin = MutableLiveData<Coin>()
    val coinOrigin: LiveData<Coin> get() = _coinOrigin

    private val _coinDestiny = MutableLiveData<Coin>()
    val coinDestiny: LiveData<Coin> get() = _coinDestiny

    private val _coinList = MutableLiveData<List<Coin>>()
    val coinList: LiveData<List<Coin>> get() = _coinList

    private val _buySell = MutableLiveData<BuySell>()
    val buySell: LiveData<BuySell> get() = _buySell

    var mountOrigin = 1.00
    var mountDestiny = 1.00

    var changeOrigin = true

    init {
        getCoins()
    }

    private fun getCoins(){
        viewModelScope.launch {
            val coin = getCoinsUseCase()
            if (coin != null){
                _coinList.postValue(coin)
                _coinOrigin.postValue(coin[0])
                _coinDestiny.postValue(coin[1])
            }
        }
    }

    fun switchCoins(){
        val origin = _coinOrigin.value
        val destiny = _coinDestiny.value

        origin.let {
            _coinDestiny.postValue(it)
        }
        destiny.let {
            _coinOrigin.postValue(it)
        }
        buySell()
    }

    fun changeCoin(coin: Coin){
        if (changeOrigin){
            _coinOrigin.postValue(coin)
        } else{
            _coinDestiny.postValue(coin)
        }
    }

    fun buySell(){
        if (mountOrigin != null && mountDestiny != null){
            val buySell = BuySell()
            buySell.buy = changeCoinOrigin(_coinOrigin.value!!, _coinDestiny.value!!, mountOrigin)
            buySell.sell = changeCoinOrigin(_coinDestiny.value!!, _coinOrigin.value!!, mountDestiny)
            _buySell.postValue(buySell)
        }
    }

    private fun formatDouble(mount: Double): Double{
        return (mount * 10.00.pow(2.00)).roundToInt() / 10.00.pow(2.00)
    }

    private fun changeCoinOrigin(coinOrigin: Coin, coinDestiny: Coin, mount: Double): Double{
        var response = 1.00
        if (coinOrigin.id == 1){
            response = formatDouble(mount * coinDestiny.value)
        } else if (coinDestiny.id == 1){
            response = formatDouble( (EURO / coinOrigin.value) * mount)
        } else{
            response = formatDouble((coinOrigin.value / coinDestiny.value) * mount)
        }
        return response
    }

    companion object {
        private const val EURO = 1.00
    }
}