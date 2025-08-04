package com.example.habitbud.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.habitbud.presentation.calendar.CalendarScreen
import com.example.habitbud.presentation.habits.HabitsScreen
import com.example.habitbud.ui.theme.HabitBudTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitBudTheme {
                HabitBudApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun HabitBudApp() {
    var currentDestination: Destination by rememberSaveable { mutableStateOf(Destination.Habits) }
    val navController = rememberNavController()

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            listOf(Destination.Habits, Destination.Calendar, Destination.Graphs).forEach {
                item(
                    icon = {
                        Icon(
                            painterResource(it.iconResId),
                            contentDescription = stringResource(it.labelResId)
                        )
                    },
                    label = { Text(stringResource(it.labelResId)) },
                    selected = it == currentDestination,
                    onClick = {
                        currentDestination = it

                        when (currentDestination) {
                            Destination.Calendar -> navController.navigate(NavItem.Calendar)
                            Destination.Graphs -> navController.navigate(NavItem.Graphs)
                            Destination.Habits -> navController.navigate(NavItem.Habits)
                        }
                    }
                )
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
            },
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ) { innerPadding ->
            NavHost(
                modifier = Modifier
                    .padding(innerPadding),
                navController = navController,
                startDestination = NavItem.Habits
            ) {
                composable<NavItem.Habits> {
                    HabitsScreen()
                }

                composable<NavItem.Calendar> {
                    CalendarScreen()
                }

                composable<NavItem.Graphs> {
                    Text(text = "Habits")
                }


            }
        }
    }
}
