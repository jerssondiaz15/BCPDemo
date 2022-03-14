package com.example.bcpdemo.ui.fragment.coins

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcpdemo.databinding.FragmentCoinBinding
import com.example.bcpdemo.ui.SplashViewModel
import com.example.bcpdemo.domain.model.Coin
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinsFragments: Fragment() {

    private var _binding: FragmentCoinBinding? = null
    private val binding: FragmentCoinBinding get() = _binding!!

    private val splashViewModel: SplashViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCoinBinding.inflate(inflater, container, false)
        initView()
        initObserver()
        return binding.root
    }

    private fun initView() {
        binding.rvFpCoinList.layoutManager = LinearLayoutManager(context)
    }

    private fun initObserver(){
        splashViewModel.coinList.observe(viewLifecycleOwner){ list ->
            binding.rvFpCoinList.adapter = CoinAdapter(list, requireContext(),object: OnItemClick{
                override fun onClick(item: Coin) {
                    splashViewModel.changeCoin(item)
                    activity?.onBackPressed()
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}