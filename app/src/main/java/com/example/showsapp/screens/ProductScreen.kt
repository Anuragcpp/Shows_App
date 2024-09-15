package com.example.showsapp.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.showsapp.models.Product
import com.example.showsapp.models.getPorductList
import com.example.showsapp.screens.components.ProductItem

@Composable
fun ProductScreen(
    modifier: Modifier = Modifier,
    onClick : (String) -> Unit
) {
    var products : List<Product> = remember {
        getPorductList()
    }

    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp)) {

        items(products) {
            product ->
            ProductItem(product, onClick)
        }
    }
}