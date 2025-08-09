package com.example.habitbud.domain.habit.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.room.Entity
import com.example.habitbud.R

@Entity
sealed class TimeOfDay(
    @param:StringRes
    val titleResId: Int,
    @param:DrawableRes
    val iconResId: Int
) {
    data object Morning : TimeOfDay(R.string.morning_label, R.drawable.ic_outline_morning_24)
    data object Noon : TimeOfDay(R.string.noon_label, R.drawable.ic_outline_noon_24)
    data object Evening : TimeOfDay(R.string.evening_label, R.drawable.ic_outline_evening_24)
    data object AllDay : TimeOfDay(R.string.all_day_label, R.drawable.ic_day_night_24)

    companion object {
        const val ALL_DAY = "ALL_DAY"
        const val MORNING = "MORNING"
        const val NOON = "NOON"
        const val EVENING = "EVENING"

        fun TimeOfDay.toData() = when (this) {
            AllDay -> ALL_DAY
            Evening -> EVENING
            Morning -> MORNING
            Noon -> NOON
        }

        fun safeValueOf(rawValue: String) = when (rawValue) {
            ALL_DAY -> AllDay
            EVENING -> Evening
            MORNING -> Morning
            NOON -> Noon
            else -> AllDay
        }
    }
}