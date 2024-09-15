package com.example.showsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.showsapp.screens.ProductDetailsScreen
import com.example.showsapp.screens.ProductScreen

@Composable
fun AppNavHost(

) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationItem.PRODUCT ) {

        composable(route = NavigationItem.PRODUCT) {
            ProductScreen {
                navController.navigate("${NavigationItem.PRODUCT_DETAILS}/${it}")
            }
        }

        composable(route = "${NavigationItem.PRODUCT_DETAILS}/${id}") {
            val id = navController.currentBackStackEntry?.id ?: "1"

            ProductDetailsScreen(productId = id)

        }

    }

}