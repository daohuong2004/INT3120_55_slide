package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.*
//doInBackground()
//Sử dụng: CoroutineScope.launch(Dispatchers.IO)
//onPreExecute()
//Sử dụng: Cập nhật trạng thái trước khi bắt đầu coroutine
// onPostExecute()
//Sử dụng: Cập nhật trạng thái sau khi coroutine hoàn thành
//onProgressUpdate()
//Sử dụng: Cập nhật tiến trình thông qua MutableState
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var message by remember { mutableStateOf("Nhấn nút để bắt đầu") }
    var progress by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    // Cập nhật trạng thái trước khi bắt đầu coroutine
                    message = "Đang xử lý..."
                    progress = 0

                    // Chạy coroutine để thực hiện tác vụ nặng
                    coroutineScope.launch {
                        val totalSteps = 100
                        for (i in 1..totalSteps) {
                            delay(50) // Giả lập công việc nặng
                            progress = i // Cập nhật tiến trình
                        }
                        // Cập nhật trạng thái sau khi hoàn thành
                        message = "Tác vụ hoàn thành!"
                    }
                }
            ) {
                Text(text = "Bắt đầu")
            }

            // Hiển thị thông báo trạng thái
            Text(text = message, modifier = Modifier.padding(top = 16.dp))

            // Hiển thị tiến trình
            LinearProgressIndicator(
                progress = progress / 100f,
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    // Sử dụng theme mặc định của Compose
    MaterialTheme {
        MainScreen()
    }
}
