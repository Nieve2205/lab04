package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Mi Aplicación") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF9065CE)
                )
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            }
        }
    )
}
