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
// Thay vào đó, trong Compose, bạn sẽ sử dụng
// các API và phương pháp xử lý trạng thái của định hướng màn hình
// thông qua code Kotlin.
//ó thể sử dụng LocalConfiguration
// để lấy thông tin về cấu hình của thiết bị, bao gồm cả định hướng màn hình.
import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScreenOrientationSample() {
    // Lấy thông tin cấu hình của thiết bị
    val configuration = LocalConfiguration.current

    // Kiểm tra định hướng màn hình
    val orientation = when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> "Landscape"
        Configuration.ORIENTATION_PORTRAIT -> "Portrait"
        else -> "Undefined"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Hiển thị thông báo về định hướng màn hình hiện tại
        Text(text = "Current Orientation: $orientation")

        // Nội dung khác thay đổi theo định hướng
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Text("Landscape content")
        } else {
            Text("Portrait content")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreenOrientationSample() {
    ScreenOrientationSample()
}
