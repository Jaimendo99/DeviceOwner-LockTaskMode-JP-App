package com.app.cellarius

import android.app.admin.DevicePolicyManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.app.cellarius.ui.theme.CellariusTheme

class MainActivity : ComponentActivity() {
    // Allowlist two apps.
    private var doMessage:String = "App's device owner state is unknown";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dpm = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

        if (savedInstanceState == null) {
            doMessage = if (dpm.isDeviceOwnerApp(applicationContext.packageName)) {
                "App is device owner"
            } else {
                "App is not device owner"
            }
        }
        setContent {
            CellariusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                            ){
                        Text(text = doMessage, modifier = Modifier.fillMaxWidth(), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                        enterLockTask(Modifier, this@MainActivity, dpm)
                        exitLockTask(Modifier ,this@MainActivity)
                    }
                }
            }
        }
    }

    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name!",
        modifier = modifier
    )
}

@Composable
fun enterLockTask(modifier: Modifier, context: MainActivity, dpm: DevicePolicyManager) {

   var texto = if (dpm.isLockTaskPermitted(context.packageName)) "app is allowed to lock"
    else "app is not allowed to lock"

    Text(text = texto)
    Button(onClick = {
            context.startLockTask()
    }, modifier = modifier) {
        Text(text = "Enter Lock Task")
    }
}

@Composable
fun exitLockTask(modifier: Modifier, context: MainActivity) {
    Button(onClick = {
        try {
            context.stopLockTask()
        }
        catch (e: Exception) {
            println(e.message)
        }
    }
        , modifier = modifier
    )
    {
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

