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
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//Lấy chiều rộng màn hình: Sử dụng LocalConfiguration.current để lấy thông tin về chiều rộng màn hình.
//Xác định số cột: Sử dụng điều kiện để xác định số lượng cột.
// Nếu chiều rộng nhỏ hơn 600dp, chỉ hiển thị 1 cột, ngược lại hiển thị 2 cột.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleAdaptiveLayout()
        }
    }
}

@Composable
fun SimpleAdaptiveLayout() {
    // Lấy chiều rộng màn hình
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp

    // Đặt số lượng cột dựa vào chiều rộng màn hình
    val columnCount = if (width < 600) 1 else 2 // 1 cột nếu chiều rộng < 600dp, ngược lại 2 cột

    // Sử dụng LazyVerticalGrid để tạo lưới
    LazyVerticalGrid(
        columns = GridCells.Fixed(columnCount),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(10) { index -> // Hiển thị 10 item
            ItemCard(index)
        }
    }
}

@Composable
fun ItemCard(index: Int) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Item $index")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAdaptiveLayout() {
    SimpleAdaptiveLayout()
}
