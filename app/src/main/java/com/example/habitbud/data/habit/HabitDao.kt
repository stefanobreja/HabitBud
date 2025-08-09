package com.example.habitbud.data.habit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.habitbud.data.habit.model.HabitDTO

@Dao
interface HabitDao {
    @Insert
    suspend fun insert(habitDTO: HabitDTO)

    @Insert
    suspend fun insertAll(habitDTOS: List<HabitDTO>)

    @Query("SELECT * FROM habitdto")
    suspend fun getAll(): List<HabitDTO>

    @Query("SELECT * FROM habitdto WHERE id = :id")
    suspend fun getById(id: Int): HabitDTO

    @Query("DELETE FROM habitdto WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("DELETE FROM habitdto")
    suspend fun deleteAll()

    @Query("UPDATE habitdto SET name = :name WHERE id = :id")
    suspend fun updateName(id: Int, name: String)

    @Query("UPDATE habitdto SET completionRate = :completionRate WHERE id = :id")
    suspend fun updateCompletionRate(id: Int, completionRate: Float)

    @Query("UPDATE habitdto SET weeklySchedule = :weeklySchedule WHERE id = :id")
    suspend fun updateWeeklySchedule(id: Int, weeklySchedule: List<String>)

    @Query("UPDATE habitdto SET timeOfDay = :timeOfDay WHERE id = :id")
    suspend fun updateTimeOfDay(id: Int, timeOfDay: String)

    @Query("UPDATE habitdto SET reps = :reps WHERE id = :id")
    suspend fun updateReps(id: Int, reps: Int)
}