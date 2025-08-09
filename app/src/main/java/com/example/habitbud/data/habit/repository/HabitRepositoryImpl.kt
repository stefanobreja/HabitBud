package com.example.habitbud.data.habit.repository

import com.example.habitbud.data.HabitDatabase
import com.example.habitbud.data.habit.model.toDomain
import com.example.habitbud.domain.habit.HabitRepository
import com.example.habitbud.domain.habit.model.Habit
import com.example.habitbud.domain.habit.model.toData

class HabitRepositoryImpl(private val db: HabitDatabase) : HabitRepository {
    override suspend fun insert(habit: Habit) = db.habitDao().insert(habit.toData())

    override suspend fun insertAll(habits: List<Habit>) =
        db.habitDao().insertAll(habits.map { it.toData() })

    override suspend fun getAll(): List<Habit> = db.habitDao().getAll().map { it.toDomain() }

    override suspend fun getById(id: Int): Habit = db.habitDao().getById(id).toDomain()

    override suspend fun deleteById(id: Int) = db.habitDao().deleteById(id)

    override suspend fun deleteAll() = db.habitDao().deleteAll()

}