package com.example.mvvmexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmexample.ui.theme.MVVMExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val viewModel: GreetingViewModel = viewModel()
    val result = viewModel.result.observeAsState(initial = 0)
    val number1 = remember {
        mutableStateOf("")
    }
    val number2 = remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = result.value.toString(),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        TextField(
            label = { Text(text = "Sayı 1") },
            value = number1.value,
            onValueChange = {
                number1.value = it
            })
        TextField(
            label = { Text(text = "Sayı 2") },
            value = number2.value,
            onValueChange = {
                number2.value = it
            })
        Button(
            onClick = {
                viewModel.topla(number1.value, number2.value)
            }
        ) {
            Text(text = "Topla")
        }
        Button(
            onClick = {
                viewModel.carp(number1.value, number2.value)
            }
        ) {
            Text(text = "Çarp")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMExampleTheme {
        Greeting("Android")
    }
}