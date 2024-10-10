package com.example.huongmanhinh
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.huongmanhinh.ui.theme.HuongmanhinhTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            HuongmanhinhTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    HuongmanhinhTheme {
//        Greeting("Android")
//    }
//}
//Trong Jetpack Compose, việc quản lý và xử lý Screen Orientation (định hướng màn hình)
// không được cấu hình trực tiếp qua XML

// như trong các ứng dụng sử dụng View system.
//Dưới đây là một ví dụ đầy đủ với Jetpack Compose
// để xử lý định hướng màn hình và thay đổi giao diện
// dựa trên chế độ Portrait và Landscape.

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // Thư viện cho Layouts
import androidx.compose.material3.* // Thư viện Material Design 3
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    // Lấy cấu hình thiết bị hiện tại (bao gồm orientation)
    val configuration = LocalConfiguration.current

    // Kiểm tra orientation của màn hình
    val orientation = configuration.orientation

    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        // UI cho Landscape (màn hình ngang)
        LandscapeContent()
    } else {
        // UI cho Portrait (màn hình dọc)
        PortraitContent()
    }
}

@Composable
fun PortraitContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Portrait Mode", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Thêm hành động cho button */ }) {
            Text(text = "Click me in Portrait")
        }
    }
}

@Composable
fun LandscapeContent() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Landscape Mode", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.width(16.dp))
        Button(onClick = { /* TODO: Thêm hành động cho button */ }) {
            Text(text = "Click me in Landscape")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPortraitContent() {
    PortraitContent()
}

@Preview(showBackground = true)
@Composable
fun PreviewLandscapeContent() {
    LandscapeContent()
}
