package com.example.ud8_1_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ud8_1_compose.ui.theme.UD8_1_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UD8_1_ComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary) {
        Row {
            Text(
                //text = "Hello $name!",
                text = "caca caca caca caca esto es una caca, quiero dormirme para siempre",
                modifier = modifier
                    .padding(15.dp)
                    .width(205.dp)
                    .height(250.dp)
                    .blur(1.dp)
                , //separar cosas
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    brush = Brush.linearGradient(listOf(Color.Red, Color.Gray,Color.Cyan)),
                    fontSize = 30.sp,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(20f , 20f)
                    )
                )
            )
            Text(
                //text = "Hello $name!",
                text = stringResource(R.string.caca),
                modifier = modifier
                    .padding(15.dp)
                    .size(100.dp)
                    .blur(1.dp)
                , //separar cosas
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 30.sp,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(5f , 10f)
                    )
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UD8_1_ComposeTheme {
        Greeting("Android")
    }
}