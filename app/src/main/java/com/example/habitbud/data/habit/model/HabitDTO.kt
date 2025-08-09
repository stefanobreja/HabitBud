package com.example.habitbud.data.habit.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.habitbud.domain.habit.model.DayOfWeek
import com.example.habitbud.domain.habit.model.Habit
import com.example.habitbud.domain.habit.model.TimeOfDay

@Entity()
data class HabitDTO(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val completionRate: Int,
    val weeklySchedule: List<String>,
    val timeOfDay: String,
    val reps: Int
)

fun HabitDTO.toDomain() = Habit(
    name = name,
    completionRate = completionRate,
    weeklySchedule = weeklySchedule.map { DayOfWeek.safeValueOf(it) },
    timeOfDay = TimeOfDay.safeValueOf(timeOfDay),
    reps = reps
)