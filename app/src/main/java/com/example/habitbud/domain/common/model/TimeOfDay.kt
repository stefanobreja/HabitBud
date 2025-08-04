package com.example.habitbud.domain.common.model

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.habitbud.R

sealed class TimeOfDay(
    @param:StringRes
    val titleResId: Int,
    @param:DrawableRes
    val iconResId: Int
) {
    data object Morning : TimeOfDay(R.string.morning_label, R.drawable.ic_outline_morning_24)
    data object Noon : TimeOfDay(R.string.noon_label, R.drawable.ic_outline_noon_24)
    data object Evening : TimeOfDay(R.string.evening_label, R.drawable.ic_outline_evening_24)
}