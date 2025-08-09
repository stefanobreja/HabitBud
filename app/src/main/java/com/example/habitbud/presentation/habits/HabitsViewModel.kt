package com.example.habitbud.presentation.habits

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habitbud.domain.habit.HabitRepository
import com.example.habitbud.domain.habit.model.Habit
import com.example.habitbud.domain.habit.model.TimeOfDay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HabitsViewModel(
    private val habitRepository: HabitRepository
) : ViewModel() {
    val habits: StateFlow<List<Habit>>
        field :MutableStateFlow<List<Habit>> = MutableStateFlow(emptyList())
    val morningHabits = habits.map { it.filter { it.timeOfDay == TimeOfDay.Morning } }
    val noonHabits = habits.map { it.filter { it.timeOfDay == TimeOfDay.Noon } }
    val eveningHabits = habits.map { it.filter { it.timeOfDay == TimeOfDay.Evening } }
    val allDayHabits = habits.map { it.filter { it.timeOfDay == TimeOfDay.AllDay } }


    init {
        getHabits()
    }

    private fun getHabits() {
        viewModelScope.launch {
            habits.value = habitRepository.getAll()
        }
    }

    fun getByTimeOfDay(timeOfDay: TimeOfDay) = habits.value.filter { it.timeOfDay == timeOfDay }
}