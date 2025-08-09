package com.example.habitbud.domain.habit.model

import com.example.habitbud.data.habit.model.HabitDTO
import com.example.habitbud.domain.habit.model.TimeOfDay.Companion.toData


data class Habit(
    val name: String,
    val completionRate: Int,
    val weeklySchedule: List<DayOfWeek>,
    val timeOfDay: TimeOfDay,
    val reps: Int
)

fun Habit.toData() = HabitDTO(
    name = name,
    completionRate = completionRate,
    weeklySchedule = weeklySchedule.map { it.name },
    timeOfDay = timeOfDay.toData(),
    reps = reps
)