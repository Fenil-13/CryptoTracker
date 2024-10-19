package com.plcoding.cryptotracker.crypto.presentation

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import java.util.Locale

data class CoinUi(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    @DrawableRes val iconRes: Int,
    val marketCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercent24hr: DisplayableNumber
)

data class DisplayableNumber(
    val value: Double,
    val formattedValue: String
)

fun Coin.toCoinUi(): CoinUi {
    return CoinUi(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        iconRes = getDrawableIdForCoin(symbol),
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        priceUsd = priceUsd.toDisplayableNumber(),
        changePercent24hr = changePercent24hr.toDisplayableNumber()
    )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale("en", "in")).apply {
        maximumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        value = this,
        formattedValue = formatter.format(this)
    )
}