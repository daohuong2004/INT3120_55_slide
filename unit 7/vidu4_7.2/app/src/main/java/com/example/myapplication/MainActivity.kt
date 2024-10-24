package com.example.myapplication

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val networkStatus = getNetworkStatus(this)
                    Greeting(networkStatus, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    private fun getNetworkStatus(context: Context): String {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork?.let {
                connectivityManager.getNetworkCapabilities(it)
            }
            when {
                networkCapabilities == null -> "Không có kết nối"
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> "Kết nối qua Wi-Fi"
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> "Kết nối qua mạng di động"
                else -> "Kết nối không xác định"
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                when (activeNetworkInfo.type) {
                    ConnectivityManager.TYPE_WIFI -> "Kết nối qua Wi-Fi"
                    ConnectivityManager.TYPE_MOBILE -> "Kết nối qua mạng di động"
                    else -> "Kết nối không xác định"
                }
            } else {
                "Không có kết nối"
            }
        }
    }
}

@Composable
fun Greeting(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        modifier = modifier
            .padding(16.dp),
        style = MaterialTheme.typography.bodyLarge // Chọn kiểu chữ phù hợp
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Kết nối qua Wi-Fi")
    }
}
