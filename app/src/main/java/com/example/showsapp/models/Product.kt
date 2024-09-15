package com.example.showsapp.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.showsapp.R

data class Product(
    var id : String,
    var name : String,
    var color : Color,
    var price : Float,
    var discountedPrice : Float,
    var size : Int,
    var ratting : Float,
    @DrawableRes var imageRes : Int
)

fun getPorductList () : List<Product> {
    return listOf(
        Product(
            id = "1",
            name = "Shoes Pink",
            color = Color.Magenta,
            price = 1200f,
            discountedPrice = 1000f,
            size = 8,
            ratting = 4.6f,
            imageRes = R.drawable.icon
        ),
        Product(
            id = "2",
            name = "Shoes blue",
            color = Color.Blue,
            price = 1200f,
            discountedPrice = 1000f,
            size = 8,
            ratting = 4.6f,
            imageRes = R.drawable.icon
        ),
        Product(
            id = "3",
            name = "Shoes red",
            color = Color.Red,
            price = 1200f,
            discountedPrice = 1000f,
            size = 8,
            ratting = 4.6f,
            imageRes = R.drawable.icon
        ),
        Product(
            id = "4",
            name = "Shoes yellow",
            color = Color.Yellow,
            price = 1200f,
            discountedPrice = 1000f,
            size = 8,
            ratting = 4.6f,
            imageRes = R.drawable.icon
        ),
        Product(
            id = "5",
            name = "Shoes cyan",
            color = Color.Cyan,
            price = 1200f,
            discountedPrice = 1000f,
            size = 8,
            ratting = 4.6f,
            imageRes = R.drawable.icon
        ),
        Product(
            id = "6",
            name = "Shoes black",
            color = Color.Black,
            price = 1200f,
            discountedPrice = 1000f,
            size = 8,
            ratting = 4.6f,
            imageRes = R.drawable.icon
        ),
        Product(
            id = "7",
            name = "Shoes cyan",
            color = Color.Cyan,
            price = 1200f,
            discountedPrice = 1000f,
            size = 8,
            ratting = 4.6f,
            imageRes = R.drawable.icon
        ),
        Product(
            id = "8",
            name = "Shoes cyan",
            color = Color.Cyan,
            price = 1200f,
            discountedPrice = 1000f,
            size = 8,
            ratting = 4.6f,
            imageRes = R.drawable.icon
        ),
        Product(
            id = "9",
            name = "Shoes cyan",
            color = Color.Cyan,
            price = 1200f,
            discountedPrice = 1000f,
            size = 8,
            ratting = 4.6f,
            imageRes = R.drawable.icon
        ),
        Product(
            id = "",
            name = "Shoes cyan",
            color = Color.Cyan,
            price = 1200f,
            discountedPrice = 1000f,
            size = 8,
            ratting = 4.6f,
            imageRes = R.drawable.icon
        ),
    )
}
