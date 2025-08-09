package com.example.habitbud.domain.habit

import com.example.habitbud.domain.habit.model.Habit

interface HabitRepository {
    suspend fun insert(habit: Habit)
    suspend fun insertAll(habits: List<Habit>)
    suspend fun getAll(): List<Habit>
    suspend fun getById(id: Int): Habit
    suspend fun deleteById(id: Int)
    suspend fun deleteAll()
}