package com.example.viduasynctask
//Thay vì sử dụng AsyncTask, mã này sử dụng CoroutineScope
// để thực hiện tác vụ nặng trong một coroutine và sử dụng delay để giả lập thời gian xử lý.
//Xây dựng một ứng dụng Android
// thực hiện một tác vụ nặng (giả lập bằng cách trì hoãn 5 giây) và hiển thị trạng thái cho người dùng
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.viduasynctask.ui.theme.ViduAsyncTaskTheme
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViduAsyncTaskTheme {
                // Thiết lập nội dung chính
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var message by remember { mutableStateOf("Nhấn nút để bắt đầu") }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { padding ->
        Button(
            onClick = {
                // Thực hiện tác vụ nặng sử dụng Coroutines
                coroutineScope.launch {
                    message = "Đang xử lý..."
                    delay(5000) // Giả lập tác vụ mất thời gian (ngủ 5 giây)
                    message = "Tác vụ hoàn thành!"
                }
            },
            modifier = Modifier.padding(padding)
        ) {
            Text(text = "Bắt đầu")
        }
        Text(
            text = message,
            modifier = Modifier.padding(padding)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ViduAsyncTaskTheme {
        MainScreen()
    }
}
