package com.gadalka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gadalka.mvi.State
import com.gadalka.mvi.ViewModel
import com.gadalka.ui.theme.GadalkaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GadalkaTheme {
                // A surface container using the 'background' color from the theme
                val viewModel = remember { ViewModel(State()) }
                val state by viewModel.state.collectAsState()
                MainScreen(state = state, performIntent = viewModel::performIntent)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GadalkaTheme {
        Greeting("Android")
    }
}