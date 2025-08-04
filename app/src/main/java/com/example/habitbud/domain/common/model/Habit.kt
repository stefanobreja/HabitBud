package com.example.habitbud.domain.common.model

import java.time.DayOfWeek
import java.time.LocalDate

data class Habit(
    val name: String,
    val completionRate: Float,
    val weeklySchedule: List<DayOfWeek>,
    val timeOfDay: TimeOfDay
)
