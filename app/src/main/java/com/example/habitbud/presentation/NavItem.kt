package com.example.habitbud.presentation

import kotlinx.serialization.Serializable

sealed interface NavItem {
    @Serializable
    data object Habits : NavItem

    @Serializable
    data object Calendar : NavItem

    @Serializable
    data object Graphs : NavItem
}