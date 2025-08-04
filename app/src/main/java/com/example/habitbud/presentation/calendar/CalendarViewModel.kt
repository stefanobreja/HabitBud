package com.example.habitbud.presentation.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalendarViewModel : ViewModel() {
    val calendarState: StateFlow<CalendarState>
        field: MutableStateFlow<CalendarState> = MutableStateFlow(CalendarState())

    init {
        mockCalendarState()
    }

    fun mockCalendarState(){
    }
}