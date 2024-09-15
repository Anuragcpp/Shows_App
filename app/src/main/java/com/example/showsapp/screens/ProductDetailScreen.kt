package com.example.showsapp.screens

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.showsapp.models.Product
import com.example.showsapp.models.getPorductList
import com.example.showsapp.screens.components.ProductColorCard
import com.example.showsapp.screens.components.ProductSizeCard
import kotlinx.coroutines.delay

@Composable
fun ProductDetailsScreen(
    productId : String = "1"
) {

    var product : Product = getPorductList().find { it.id == productId }!!
    var xOffset by remember { mutableStateOf(800.dp) }
    var yOffset by remember { mutableStateOf(800.dp) }
    var selectedColor by remember { mutableStateOf(product.color) }
    var productScale by remember { mutableFloatStateOf(0.6f) }
    var productRotate by remember { mutableFloatStateOf(-60f) }
    var selectedSize by remember { mutableStateOf( product.size.toString()) }
    var isFavrate by remember { mutableStateOf( false) }



    var annimatinXOffset = animateDpAsState(
        targetValue = xOffset,
        label = "",
        animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing)
    )
    var annimatinYOffset = animateDpAsState(
        targetValue = yOffset,
        animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing),
        label = ""
    )

    var animationProductScale = animateFloatAsState(
        targetValue = productScale,
        label = ""
    )

    var animationProductRotate = animateFloatAsState(
        targetValue = productRotate,
        label = ""
    )



    LaunchedEffect(key1 = true) {
        delay(250)
        xOffset = 140.dp
        yOffset = (-140).dp
        productScale = 1f
        productRotate = -30f
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {

        // rounded colour for animation
        Box(
            modifier = Modifier
                .offset(x = annimatinXOffset.value, y = annimatinYOffset.value)
                .alpha(.3f)
                .size(400.dp)
                .background(
                    shape = CircleShape,
                    color = selectedColor
                )
        )

        // back button
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .shadow(
                    elevation = 24.dp,
                    spotColor = DefaultShadowColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(22.dp)
                )
                .size(36.dp)
        ) {

            Icon(
                imageVector = Icons.Rounded.KeyboardArrowLeft ,
                contentDescription = null
            )
            
        }


        Column  {


            // shoe icon
            AsyncImage(
                model = product.imageRes,
                contentDescription = null,
                modifier = Modifier
                    .scale(animationProductScale.value)
                    .rotate(animationProductRotate.value)
                    .padding(end = 48.dp, top = 30.dp)
            )

            // price and rating
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Column {

                    Text(
                        text = "Sneaker",
                        color = Color.Black,
                        fontSize = 10.sp,
                        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                    )

                    Text(
                        text = "${product.name}",
                        color = Color.Black,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(top = 2.dp),
                        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                    )

                    Row (
                        modifier = Modifier
                            .padding(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Star,
                            modifier = Modifier.size(18.dp),
                            tint = Color(0xFFFFDA45),
                            contentDescription =null
                        )

                        Text(
                            text = "${product.ratting.toString()}",
                            color = Color.Black,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 4.dp),
                            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                        )

                    }


                }

                Text(
                    text = "Rs. ${product.discountedPrice}",
                    modifier = Modifier.padding(start = 4.dp),
                    color = Color.Black,
                    fontSize = 36.sp,
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                )

            }

            //size
            Text(
                text = "Size",
                color = Color.Black,
                fontSize = 10.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 22.dp)
            )



            //size chat
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp)
                    .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){

                ProductSizeCard(
                    size = "8",
                    isSelected = selectedSize == "8"
                ) {
                    selectedSize = "8"
                }

                ProductSizeCard(
                    size = "9",
                    isSelected = selectedSize == "9"
                ) {
                    selectedSize = "9"
                }

                ProductSizeCard(
                    size = "10",
                    isSelected = selectedSize == "10"
                ) {
                    selectedSize = "10"
                }


                ProductSizeCard(
                    size = "11",
                    isSelected = selectedSize == "11"
                ) {
                    selectedSize = "11"
                }

                ProductSizeCard(
                    size = "12",
                    isSelected = selectedSize == "12"
                ) {
                    selectedSize = "12"
                }

            }


            //colors
            Text(
                text = "Color",
                color = Color.Black,
                fontSize = 10.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 15.dp)
            )

            //color chat
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp)
                    .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {

                ProductColorCard(color = Color.Blue, isSelected = selectedColor == Color.Blue) {
                    selectedColor = Color.Blue
                }

                ProductColorCard(color = Color.Yellow, isSelected = selectedColor == Color.Yellow) {
                    selectedColor = Color.Yellow
                }

                ProductColorCard(color = Color.Cyan, isSelected = selectedColor == Color.Cyan) {
                    selectedColor = Color.Cyan
                }

                ProductColorCard(color = Color.Magenta, isSelected = selectedColor == Color.Magenta) {
                    selectedColor = Color.Magenta
                }

                ProductColorCard(color = Color.DarkGray, isSelected = selectedColor == Color.DarkGray) {
                    selectedColor = Color.DarkGray
                }

            }



            Text(
                text = "Mobile application development is the process of creating software for mobile devices123. It involves software writing, UX testing, and customer marketing3. Mobile devices can include personal digital assistants (PDA), enterprise digital assistants (EDA), or mobile phones1. The software can be preinstalled on the device, downloaded from a mobile app store or accessed through a mobile web browser",
                color = Color.Black,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 10.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Row (
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(bottom = 24.dp)
            ){


                IconButton(
                    onClick = { isFavrate = !isFavrate}
                ) {

                    Icon(
                        imageVector = if (isFavrate) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder ,
                        contentDescription = null,
                        tint = if (isFavrate) Color.Red else MaterialTheme.colorScheme.onSurface
                    )

                }


                Spacer(modifier = Modifier.weight(4f))


                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(start = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue
                    )

                ) {

                    Icon(
                        imageVector = Icons.Rounded.ShoppingCart,
                        contentDescription = null
                    )
                    
                    Spacer(modifier = Modifier.width(10.dp))

                    Text(text = "Add to Cart")

                }

            }



        }



    }
}
