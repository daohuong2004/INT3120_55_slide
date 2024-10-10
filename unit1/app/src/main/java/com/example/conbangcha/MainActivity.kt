//package com.example.conbangcha
//
//import android.os.Bundle
//import android.text.Layout.Alignment
//import android.view.Surface
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.core.content.pm.ShortcutInfoCompat
//import com.example.conbangcha.ui.theme.ConbangchaTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            ConbangchaTheme{
//                Surface(
//
//                )
//            }
//        }
//    }
//}
//
//@Composable
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ConbangchaTheme {
//        Greeting("Android")
//    }
//}
package com.example.conbangcha
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.constraintlayout.compose.Dimension
import com.example.conbangcha.ui.theme.ConbangchaTheme
import kotlinx.coroutines.NonDisposableHandle.parent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConbangchaTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintLayoutExample()
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // Tạo references cho các button
        val (button1, button2) = createRefs()

        // Button 1
        Button(
            onClick = { /*TODO: Xử lý sự kiện click*/ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(button2.start)
                width = Dimension.fillToConstraints
            }
        ) {
            Text("Button 1")
        }

        // Button 2
        Button(
            onClick = { /*TODO: Xử lý sự kiện click*/ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(button1.end)
                end.linkTo(parent.end)
                var width = Dimension.fillToConstraints
            }
        ) {
            Text("Button 2")
        }
    }
}

