package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // Opt-in for experimental Material3 API
@Composable
fun MyApp() {
    // State for the list of items
    val itemsList = remember { mutableStateListOf<String>() }

    // State for the text field
    var text by remember { mutableStateOf(TextFieldValue("")) }

    // Main container
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Aplicación") },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF6200EE)),
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            items(itemsList) { item ->
                Text(
                    text = item,
                    fontSize = 18.sp,
                    color = Color(0xFF333333),
                    modifier = Modifier.padding(16.dp)
                )
            }

            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Ingrese texto") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
