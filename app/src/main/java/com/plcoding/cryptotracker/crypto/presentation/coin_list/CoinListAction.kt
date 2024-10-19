package com.plcoding.cryptotracker.crypto.presentation.coin_list

import com.plcoding.cryptotracker.crypto.presentation.CoinUi

sealed interface CoinListAction {
    data class OnClickCoin(val coin: CoinUi): CoinListAction
    data object OnRefresh: CoinListAction
}