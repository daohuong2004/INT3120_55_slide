package com.example.myapplication
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
//import com.example.myapplication.ui.theme.MyApplicationTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            MyApplicationTheme {
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
//    MyApplicationTheme {
//        Greeting("Android")
//    }
//}
import android.content.pm.ActivityInfo
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
//LocalConfiguration.current: Lấy thông tin cấu hình hiện tại của thiết bị (bao gồm định hướng màn hình).
//orientation: Lưu trữ định hướng màn hình (dọc hoặc ngang).
//Cấu trúc if: Kiểm tra định hướng màn hình. Nếu là Landscape, gọi LandscapeScreen(), ngược lại gọi PortraitScreen().
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
    // Lấy cấu hình của thiết bị để kiểm tra orientation (định hướng)
    val configuration = LocalConfiguration.current
    val orientation = configuration.orientation

    // Nếu là Landscape (màn hình ngang) hiển thị giao diện ngang, ngược lại là dọc
    if (orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
        LandscapeScreen()
    } else {
        PortraitScreen()
    }
}

@Composable
fun PortraitScreen() {
    // Giao diện khi ở chế độ Portrait (màn hình dọc)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Portrait Mode", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Thêm hành động ở đây nếu cần */ }) {
            Text(text = "Click me in Portrait")
        }
    }
}

@Composable
fun LandscapeScreen() {
    // Giao diện khi ở chế độ Landscape (màn hình ngang)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Landscape Mode", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.width(16.dp))
        Button(onClick = { /* Thêm hành động ở đây nếu cần */ }) {
            Text(text = "Click me in Landscape")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPortraitScreen() {
    PortraitScreen()
}

@Preview(showBackground = true)
@Composable
fun PreviewLandscapeScreen() {
    LandscapeScreen()
}
