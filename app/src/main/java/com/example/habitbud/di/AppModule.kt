package com.example.habitbud.di

import androidx.room.Room
import com.example.habitbud.data.HabitDatabase
import com.example.habitbud.data.habit.repository.HabitRepositoryImpl
import com.example.habitbud.data.habit.repository.HabitRepositoryMockImpl
import com.example.habitbud.domain.habit.HabitRepository
import com.example.habitbud.presentation.calendar.CalendarViewModel
import com.example.habitbud.presentation.habits.HabitsViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


const val MOCK_ENABLED = true
val appModules = module {
    single {
        Room.databaseBuilder(
            get(),
            HabitDatabase::class.java, "habit_database"
        )
            .fallbackToDestructiveMigration(false)
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }

    single<HabitRepository> {
        if (MOCK_ENABLED) HabitRepositoryMockImpl
        else HabitRepositoryImpl(get())
    }
}

val viewModelsModule = module {
    viewModel<HabitsViewModel> { HabitsViewModel(get()) }
    viewModel<CalendarViewModel> { CalendarViewModel() }
}