package com.example.sdngspacervdivider
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
//import com.example.sdngspacervdivider.ui.theme.SửDụngSpacerVàDividerTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            SửDụngSpacerVàDividerTheme {
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
//    SửDụngSpacerVàDividerTheme {
//        Greeting("Android")
//    }
//}
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // Import Spacer và Column
import androidx.compose.material3.* // Import Text và Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.sdngspacervdivider.ui.theme.SửDụngSpacerVàDividerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SửDụngSpacerVàDividerTheme {
                // Gọi giao diện NewsArticleList
                NewsArticleList()
            }
        }
    }
}

@Composable
fun NewsArticleList() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Tiêu đề của danh sách
        Text(
            text = "Danh sách bài viết",
            style = MaterialTheme.typography.headlineMedium // Thay vì h5, dùng trong Material3
        )

        // Spacer để tạo khoảng trống giữa tiêu đề và nội dung danh sách
        Spacer(modifier = Modifier.height(16.dp))

        // Danh sách các bài viết
        ArticleItem(title = "Bài viết 1", description = "Mô tả ngắn về bài viết 1")
        Divider(color = Color.Gray, thickness = 1.dp)

        ArticleItem(title = "Bài viết 2", description = "Mô tả ngắn về bài viết 2")
        Divider(color = Color.Gray, thickness = 1.dp)

        ArticleItem(title = "Bài viết 3", description = "Mô tả ngắn về bài viết 3")
        Divider(color = Color.Gray, thickness = 1.dp)

        // Spacer để tạo khoảng trống cuối cùng dưới danh sách
        Spacer(modifier = Modifier.height(16.dp))

        // Button ở cuối danh sách
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Tải thêm bài viết")
        }
    }
}

@Composable
fun ArticleItem(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(4.dp)) // Khoảng cách giữa tiêu đề và mô tả
        Text(text = description, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SửDụngSpacerVàDividerTheme {
        NewsArticleList()
    }
}
