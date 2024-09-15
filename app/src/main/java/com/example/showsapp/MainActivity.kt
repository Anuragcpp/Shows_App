package com.example.showsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.showsapp.navigation.AppNavHost
import com.example.showsapp.screens.ProductDetailsScreen
import com.example.showsapp.screens.ProductScreen
import com.example.showsapp.ui.theme.ShowsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShowsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    innerPadding ->
                   //ProductScreen()
                    //ProductDetailsScreen()
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShowsAppTheme {
        Greeting("Android")
    }
}