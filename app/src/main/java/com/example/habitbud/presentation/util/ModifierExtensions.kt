package com.example.habitbud.presentation.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Modifier.cardBackground(
    color: Color = MaterialTheme.colorScheme.surface,
    radius: Dp = 12.dp,
    elevation: Dp = 1.dp,
    bottomMargin: Dp = 0.dp
) = this
    .padding(bottom = elevation + bottomMargin)
    .shadow(elevation = elevation, shape = RoundedCornerShape(radius))
    .background(
        color = color,
        shape = RoundedCornerShape(radius)
    )
