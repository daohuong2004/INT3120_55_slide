package com.example.unit112vidu1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unit112vidu1.ui.theme.Unit112Vidu1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unit112Vidu1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShowCount() // Gọi hàm ShowCount() để hiển thị số 0
                }
            }
        }
    }
}

@Composable
fun ShowCount() {
    androidx.compose.material3.Text(
        text = "0", // Số 0 hiển thị
        modifier = Modifier
            .fillMaxWidth()
            .background(androidx.compose.ui.graphics.Color.LightGray)
            .padding(16.dp),
        color = androidx.compose.ui.graphics.Color.Blue, // Màu chữ (thay thế cho colorResource để đơn giản)
        fontSize = 48.sp, // Kích thước chữ lớn
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, // Chữ in đậm
        textAlign = androidx.compose.ui.text.style.TextAlign.Center // Căn giữa
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    androidx.compose.material3.Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Unit112Vidu1Theme {
        Greeting("Android")
    }
}
