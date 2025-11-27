package com.example.myroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.myroom.ui.theme.MyroomTheme
import com.example.myroom.view.uicontroller.SiswaApp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Ini konteks Composable, aman memanggil fungsi Composable
            MyroomTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    // SiswaApp adalah Composable, jadi bisa dipanggil di sini
                    SiswaApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
