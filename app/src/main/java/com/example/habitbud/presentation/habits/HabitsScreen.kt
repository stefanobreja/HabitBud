package com.example.habitbud.presentation.habits

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun HabitsScreen(viewModel: HabitsViewModel = koinViewModel()) {
    val morningHabits by viewModel.morningHabits.collectAsState(emptyList())
    val noonHabits by viewModel.noonHabits.collectAsState(emptyList())
    val eveningHabits by viewModel.eveningHabits.collectAsState(emptyList())
    val allDayHabits by viewModel.allDayHabits.collectAsState(emptyList())

    HabitsView(morningHabits, noonHabits, eveningHabits, allDayHabits)
}