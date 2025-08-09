package com.example.habitbud.domain.habit.model


enum class DayOfWeek {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

    companion object {
        fun safeValueOf(rawValue: String) =
            entries.find { it.name == rawValue } ?: Monday
    }
}