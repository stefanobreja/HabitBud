package com.example.habitbud.presentation

import android.os.Parcelable
import com.example.habitbud.R
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class Destination(val labelResId: Int, val iconResId: Int) : Parcelable {
    data object Habits : Destination(R.string.home, R.drawable.ic_routine_24dp)
    data object Calendar : Destination(R.string.calendar, R.drawable.outline_calendar_month_24)
    data object Graphs : Destination(R.string.graphs, R.drawable.ic_chart_24)
}