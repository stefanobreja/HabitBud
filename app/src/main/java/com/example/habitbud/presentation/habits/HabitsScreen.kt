package com.example.habitbud.presentation.habits

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habitbud.R
import com.example.habitbud.domain.common.model.TimeOfDay
import com.example.habitbud.presentation.util.cardBackground
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.time.temporal.TemporalAdjusters
import java.util.Locale

@Composable
fun HabitsScreen() {
    val currentWeek by remember {
        mutableStateOf(getCurrentWeek())
    }
    val currentDay by remember {
        mutableStateOf(LocalDate.now())
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row {
            Text(
                text =
                    buildAnnotatedString {
                        val currentMonthName = currentDay.month.getDisplayName(
                            TextStyle.FULL_STANDALONE,
                            Locale.getDefault()
                        )
                        val currentDay = currentDay.dayOfMonth.toString()
                        val todayDate =
                            stringResource(R.string.today_date, currentMonthName, currentDay)
                        val dateStyle =
                            SpanStyle(color = MaterialTheme.colorScheme.outline)

                        append(todayDate)
                        val currentMonthStart = todayDate.indexOf(currentMonthName)
                        val currentMonthEnd = currentMonthStart + currentMonthName.length
                        val currentDayStart = todayDate.indexOf(currentDay)
                        val currentDayEnd = currentDayStart + currentDay.length
                        addStyle(dateStyle, currentMonthStart, currentMonthEnd)
                        addStyle(dateStyle, currentDayStart, currentDayEnd)
                    },
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }

        Row(
            Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .cardBackground()
                .padding(8.dp)
        ) {
            currentWeek.forEach {
                it?.let {
                    DayItem(
                        modifier = Modifier.weight(1f), date = it
                    )
                }
            }
        }
        TimeOfDayItems(timeOfDay = TimeOfDay.Morning)
        TimeOfDayItems(timeOfDay = TimeOfDay.Noon)
        TimeOfDayItems(timeOfDay = TimeOfDay.Evening)
    }

}

@Composable
fun TimeOfDayItems(modifier: Modifier = Modifier, timeOfDay: TimeOfDay) {
    Column(
        modifier = modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .cardBackground()
            .padding(8.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(painterResource(timeOfDay.iconResId), contentDescription = null)
            Text(text = stringResource(timeOfDay.titleResId))
        }
        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .cardBackground()
                .padding(8.dp)
        ) {
        }
    }

}

@Composable
fun DayItem(modifier: Modifier = Modifier, date: LocalDate) {
    Column(
        modifier = modifier.wrapContentWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = date.format(DateTimeFormatter.ofPattern("E")),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = date.dayOfMonth.toString(),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

    }
}

private fun getCurrentWeek(): List<LocalDate?> {
    val today = LocalDate.now()
    val monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
    return (0..6).map { monday.plusDays(it.toLong()) }
}

@Preview
@Composable
fun DayItemPreview() {
    DayItem(date = LocalDate.now())
}