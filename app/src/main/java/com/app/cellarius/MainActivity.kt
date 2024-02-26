package com.app.cellarius

import android.app.admin.DevicePolicyManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getSystemService
import com.app.cellarius.ui.theme.CellariusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            CellariusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("Android")
                        enterLockTask(Modifier, this@MainActivity)
                        exitLockTask("",Modifier ,this@MainActivity)
                    }
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun enterLockTask(modifier: Modifier, context: MainActivity) {
    Button(onClick = {
            context.startLockTask()
    }, modifier = modifier) {
        Text(text = "Enter Lock Task")
    }
}

@Composable
fun exitLockTask(name: String, modifier: Modifier, context: MainActivity) {
    Button(onClick = {
        try {
            context.stopLockTask()
        }
        catch (e: Exception) {
            println(e.message)
        }
    }) {
        Text(text = "Exit Lock Task")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CellariusTheme {
        Greeting("Android")
    }
}

