package com.example.habitbud.presentation.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habitbud.domain.habit.model.DayCompleted
import com.example.habitbud.domain.habit.model.getColor
import com.example.habitbud.presentation.util.cardBackground
import com.example.habitbud.presentation.util.conditional
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

@Composable
fun CalendarView() {
    val today = LocalDate.now()

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = today.format(DateTimeFormatter.ofPattern("eee d MMMM")),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Column(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .cardBackground()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val weeks = getWeeksAligned(today.year, today.month.value)

                weeks.forEach { week ->
                    Row(Modifier.fillMaxWidth()) {
                        week.forEach {
                            Box(
                                modifier = Modifier
                                    .weight(1f),
                                contentAlignment = Alignment.Center
                            ) {
                                if (it != null) {
                                    Box(
                                        modifier = Modifier
                                            .size(32.dp) // or your preferred size
                                            .conditional(it == today.dayOfMonth) {
                                                clip(CircleShape)
                                                border(
                                                    1.dp,
                                                    MaterialTheme.colorScheme.onSurfaceVariant,
                                                    CircleShape
                                                )
                                            },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .background(
                                                    color = DayCompleted.Completed.getColor(),
                                                    shape = CircleShape
                                                )
                                                .size(12.dp)
                                        )
                                    }
                                } else {
                                    Spacer(modifier = Modifier.size(32.dp)) // keeps layout aligned
                                }
                            }
                        }
                    }
                }
                Row(Modifier.fillMaxWidth()) {
                    listOf("M", "T", "W", "T", "F", "S", "S").forEach {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = it,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

fun getWeeksAligned(year: Int, month: Int): List<List<Int?>> {
    val yearMonth = YearMonth.of(year, month)
    val firstDayOfMonth = yearMonth.atDay(1)
    val daysInMonth = yearMonth.lengthOfMonth()

    val dayOfWeekIndex = (firstDayOfMonth.dayOfWeek.value + 6) % 7 // Monday = 0, Sunday = 6
    val startPadding = List(dayOfWeekIndex) { null }

    val days = (1..daysInMonth).toList()
    val paddedDays = startPadding + days

    val endPaddingSize = (7 - paddedDays.size % 7) % 7
    val endPadding = List(endPaddingSize) { null }

    val finalDays = paddedDays + endPadding

    return finalDays.chunked(7)
}
