package com.example.showsapp.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProductColorCard(
    modifier: Modifier = Modifier,
    color: Color,
    isSelected : Boolean,
    onClick : () -> Unit
) {

    val borderColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent

    Box(
        modifier = Modifier
            .border(
                width = 3.dp,
                shape = CircleShape,
                color = borderColor
            ).background(
                color = color,
                shape = CircleShape
            ).size(24.dp)
            .clip(CircleShape)
            .clickable { onClick() }
    )



}