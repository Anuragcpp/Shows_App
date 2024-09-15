package com.example.showsapp.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.showsapp.R
import com.example.showsapp.models.Product

@Composable
fun ProductItem(
    product: Product = Product(
        id = "1",
        name = "Shoes Pink",
        color = Color.Magenta,
        price = 1200f,
        discountedPrice = 1000f,
        size = 8,
        ratting = 4.6f,
        imageRes = R.drawable.icon
    ),
    onClick : (String) -> Unit
) {

    var color by remember {
        mutableStateOf(product.color)
    }

    var isFavrate by remember {
        mutableStateOf(false)
    }



    Box(
        modifier = Modifier
            .padding(20.dp)
            .size(168.dp, 190.dp)
            .clickable { onClick(product.id) }
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(.2f)
                .background(color = color, shape = RoundedCornerShape(22.dp))
        )



        IconButton(
            onClick = {
                isFavrate = !isFavrate
            },
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {

            Icon(
                imageVector = if (isFavrate) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                contentDescription = null
            )


        }

        Text(
            text = product.size.toString(),
            fontWeight = FontWeight.Bold,
            color = color.copy(alpha = 0.3f),
            fontSize = 120.sp,
            modifier = Modifier
                .align(Alignment.TopCenter)
        )

       AsyncImage(
           model = product.imageRes,
           contentDescription =null,
           modifier = Modifier
               .fillMaxSize()
               .align(Alignment.Center)
               .rotate(-30f)
               .offset(30.dp, (-20).dp)
       )

        Column ( modifier = Modifier
            .align(Alignment.BottomEnd)
        ){

            Text(
                text = "Rs. ${product.discountedPrice}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(end = 8.dp)
            )

            Text(
                text = "Rs. ${product.discountedPrice}",
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(end = 8.dp, bottom = 8.dp)
                    .align(Alignment.End),
                textDecoration = TextDecoration.LineThrough
            )



        }



    }


}