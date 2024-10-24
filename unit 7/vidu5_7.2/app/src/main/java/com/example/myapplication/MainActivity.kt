package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.net.URL

private const val BASE_URL = "https://www.googleapis.com/books/v1/volumes?"
private const val QUERY_PARAM = "q"
private const val MAX_RESULTS = "maxResults"
private const val PRINT_TYPE = "printType"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold { innerPadding ->
                    val builtURI = buildURI("pride+prejudice", "10", "books")
                    Greeting(builtURI.toString(), modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    private fun buildURI(query: String, maxResults: String, printType: String): URL {
        // Xây dựng URI cho yêu cầu
        val builtURI = Uri.parse(BASE_URL).buildUpon()
            .appendQueryParameter(QUERY_PARAM, query)
            .appendQueryParameter(MAX_RESULTS, maxResults)
            .appendQueryParameter(PRINT_TYPE, printType)
            .build()

        return URL(builtURI.toString())
    }
}

@Composable
fun Greeting(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        modifier = modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting("https://www.googleapis.com/books/v1/volumes?q=pride+prejudice&maxResults=10&printType=books")
}
