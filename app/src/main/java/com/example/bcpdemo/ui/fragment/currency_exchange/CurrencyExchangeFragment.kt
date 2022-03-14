package com.example.bcpdemo.ui.fragment.currency_exchange

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bcpdemo.R
import com.example.bcpdemo.databinding.FragmentCurrencyExchangeBinding
import com.example.bcpdemo.ui.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyExchangeFragment: Fragment() {

    private var _binding: FragmentCurrencyExchangeBinding? = null
    private val binding: FragmentCurrencyExchangeBinding get() = _binding!!

    private val splashViewModel: SplashViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrencyExchangeBinding.inflate(inflater, container, false)
        initView()
        initObserver()
        return binding.root
    }

    private fun initView() {
        binding.apply {
            iFceCard.etCcccCoinOrigin.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    // Nothing to implement.
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // Nothing to implement.
                }

                override fun afterTextChanged(s: Editable?) {
                    if (s.toString() != "" && s.toString() != "."){
                        splashViewModel.mountOrigin = s.toString().toDouble()
                        splashViewModel.buySell()
                    }
                }
            })
            iFceCard.mcvCcccCoinOrigin.setOnLongClickListener {
                val bundle = Bundle()
                bundle.putInt("id", id)
                findNavController().navigate(
                    R.id.action_currency_exchange_to_coins,
                    bundle
                )
                splashViewModel.changeOrigin = true
                true
            }
            iFceCard.etCcccCoinDestiny.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    // Nothing to implement.
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // Nothing to implement.
                }

                override fun afterTextChanged(s: Editable?) {
                    if (s.toString() != "" && s.toString() != "."){
                        splashViewModel.mountDestiny = s.toString().toDouble()
                        splashViewModel.buySell()
                    }
                }
            })
            iFceCard.mcvCcccCoinDestiny.setOnLongClickListener {
                val bundle = Bundle()
                bundle.putInt("id", id)
                findNavController().navigate(
                    R.id.action_currency_exchange_to_coins,
                    bundle
                )
                splashViewModel.changeOrigin = false
                true
            }
            iFceCard.ivCcccChange.setOnClickListener {
                splashViewModel.switchCoins()
            }
        }
    }

    private fun initObserver() {
        binding.apply {
            splashViewModel.coinOrigin.observe(viewLifecycleOwner){ origin ->
                iFceCard.tvCcccCoinOrigin.text = origin.coin
            }
            splashViewModel.coinDestiny.observe(viewLifecycleOwner){ destiny ->
                iFceCard.tvCcccCoinDestiny.text = destiny.coin
            }
            splashViewModel.buySell.observe(viewLifecycleOwner){ buySell ->
                iFceCard.tvFceBuySell.text = "Compra: ${buySell.buy} | Venta: ${buySell.sell}"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}