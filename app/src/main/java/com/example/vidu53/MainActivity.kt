package com.example.vidu53

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.layout.WindowSizeClass
import androidx.window.layout.WindowMetricsCalculator

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalConfiguration

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Vidu53Theme {
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
//    Vidu53Theme {
//        Greeting("Android")
//    }
//}

//@Composable
//fun Greeting() {
//    Text(text = stringResource(id = R.string.greeting)) // Sẽ lấy chuỗi phù hợp với ngôn ngữ hiện tại
//}



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
    val windowSizeClass = calculateWindowSizeClass()
    Scaffold(
        content = { innerPadding ->
            ResponsiveLayout(windowSizeClass, innerPadding)
        }
    )
}

@Composable
fun ResponsiveLayout(windowSizeClass: WindowSizeClass, innerPadding: PaddingValues) {
    // Thêm padding từ innerPadding vào layout
    Column(modifier = Modifier.padding(innerPadding)) {
        when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                // Layout cho màn hình nhỏ (điện thoại)
                CompactLayout()
            }
            WindowWidthSizeClass.Medium -> {
                // Layout cho màn hình trung bình (tablet)
                MediumLayout()
            }
            WindowWidthSizeClass.Expanded -> {
                // Layout cho màn hình lớn (desktop, tablet lớn)
                ExpandedLayout()
            }
        }
    }
}

@Composable
fun CompactLayout() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text("Compact Layout", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Giao diện này tối ưu cho màn hình nhỏ như điện thoại.", fontSize = 14.sp)
    }
}

@Composable
fun MediumLayout() {
    Row(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Medium Layout", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text("Giao diện này tối ưu cho màn hình trung bình như tablet.", fontSize = 16.sp)
    }
}

@Composable
fun ExpandedLayout() {
    Row(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Expanded Layout", fontSize = 24.sp)
        Spacer(modifier = Modifier.width(16.dp))
        Text("Giao diện này tối ưu cho màn hình lớn như desktop hoặc tablet lớn.", fontSize = 18.sp)
    }
}

@Composable
fun calculateWindowSizeClass(): WindowSizeClass {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    return WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(context).bounds
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}