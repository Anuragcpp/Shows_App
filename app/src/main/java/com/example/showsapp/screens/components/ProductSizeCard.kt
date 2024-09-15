package com.example.showsapp.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProductSizeCard(
    modifier: Modifier = Modifier,
    size : String,
    isSelected : Boolean,
    onClick : () -> Unit
) {
    val backgroundColor = if(isSelected) Color.Red else Color.White
    val border = if (isSelected) 0.dp else 0.8.dp
    val textColor = if (isSelected) Color.White else Color.Black

    Text(
        text = size,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = border,
                color = Color.Black,
                shape = RoundedCornerShape(12.dp)
            ).background(backgroundColor)
            .clickable { onClick() }
            .padding(12.dp),
        fontSize = 12.sp,
        color = textColor
    )

}