package com.example.habitbud.data.habit.repository

import com.example.habitbud.domain.habit.HabitRepository
import com.example.habitbud.domain.habit.model.DayOfWeek
import com.example.habitbud.domain.habit.model.Habit
import com.example.habitbud.domain.habit.model.TimeOfDay

object HabitRepositoryMockImpl : HabitRepository {
    override suspend fun insert(habit: Habit) {}

    override suspend fun insertAll(habits: List<Habit>) {}

    override suspend fun getAll(): List<Habit> = habits

    override suspend fun getById(id: Int): Habit = habits.first()

    override suspend fun deleteById(id: Int) {}

    override suspend fun deleteAll() {}

    private val habits = listOf(
        Habit(
            name = "Walk",
            completionRate = 50,
            weeklySchedule = listOf(
                DayOfWeek.Monday,
                DayOfWeek.Wednesday,
                DayOfWeek.Friday,
                DayOfWeek.Sunday
            ),
            timeOfDay = TimeOfDay.AllDay,
            reps = 2
        ),
        Habit(
            name = "Read",
            completionRate = 50,
            weeklySchedule = listOf(
                DayOfWeek.Monday,
                DayOfWeek.Wednesday,
                DayOfWeek.Friday,
                DayOfWeek.Sunday
            ),
            timeOfDay = TimeOfDay.Noon,
            reps = 1
        ),
        Habit(
            name = "Exercise",
            completionRate = 0,
            weeklySchedule = listOf(
                DayOfWeek.Monday,
                DayOfWeek.Wednesday,
                DayOfWeek.Friday,
                DayOfWeek.Sunday
            ),
            timeOfDay = TimeOfDay.Evening,
            reps = 1
        )
    )
}