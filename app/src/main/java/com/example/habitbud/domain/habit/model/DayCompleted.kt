package com.example.habitbud.domain.habit.model

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.habitbud.ui.theme.greenSuccess
import com.example.habitbud.ui.theme.redFailure
import com.example.habitbud.ui.theme.yellowNotCompleted

sealed interface DayCompleted {
    data object Completed : DayCompleted
    data object PartiallyCompleted : DayCompleted
    data object NotCompleted : DayCompleted
}

@Composable
fun DayCompleted.getColor(): Color = when (this) {
    DayCompleted.Completed -> MaterialTheme.colorScheme.greenSuccess
    DayCompleted.PartiallyCompleted -> MaterialTheme.colorScheme.yellowNotCompleted
    DayCompleted.NotCompleted -> MaterialTheme.colorScheme.redFailure
}
