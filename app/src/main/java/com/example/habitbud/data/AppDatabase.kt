package com.example.habitbud.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.habitbud.data.habit.HabitDao
import com.example.habitbud.data.habit.model.HabitDTO
import com.google.gson.Gson


@Database(entities = [HabitDTO::class], version = 1)
@TypeConverters(Converters::class)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
}

class Converters {
    @TypeConverter
    fun fromStringList(value: List<String>): String =
        Gson().toJson(value)

    @TypeConverter
    fun getStringList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}