package com.example.bcpdemo.ui.fragment.coins

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bcpdemo.R
import com.example.bcpdemo.databinding.CoinItemBinding
import com.example.bcpdemo.domain.model.Coin

class CoinAdapter(
    private var coinList: List<Coin>,
    private var context: Context,
    private val listOnItemClick: OnItemClick) :
    RecyclerView.Adapter<CoinAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CoinItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val coin = coinList[position]
        holder.bind(coin, position)
    }

    override fun getItemCount(): Int = coinList.size

    inner class ViewHolder(private val binding: CoinItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Coin, position: Int) {
            binding.apply {
                if (position == 0){
                    vCiLine.visibility = View.GONE
                }
                imvCiFlag.setImageDrawable(ContextCompat.getDrawable(context, getIconDrawableId(item.id)))
                tvCiNameCountry.text = item.country
                tvCiCoin.text = "1 EUR = ${item.value} ${item.nom}"
            }

            binding.root.setOnClickListener {
                listOnItemClick.onClick(item)
            }
        }
    }

    private fun getIconDrawableId(id: Int): Int {
        return when (id) {
            1 -> R.drawable.union_europea
            2 -> R.drawable.united_states
            3 -> R.drawable.japon
            4 -> R.drawable.united_kingdom
            5 -> R.drawable.suiza
            6 -> R.drawable.canada
            7 -> R.drawable.peru
            else -> {
                R.drawable.ic_launcher_foreground
            }
        }
    }
}

interface OnItemClick {
    fun onClick(item: Coin)
}




