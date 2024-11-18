package com.example.kakaowebtoon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme
import com.example.kakaowebtoon.ui.theme.body1Regular
import com.example.kakaowebtoon.ui.theme.body2Regular
import com.example.kakaowebtoon.ui.theme.body3Regular
import com.example.kakaowebtoon.ui.theme.body4SemiBold
import com.example.kakaowebtoon.ui.theme.body5Regular
import com.example.kakaowebtoon.ui.theme.body6Regular
import com.example.kakaowebtoon.ui.theme.caption1Bold
import com.example.kakaowebtoon.ui.theme.caption2Medium
import com.example.kakaowebtoon.ui.theme.caption3Light
import com.example.kakaowebtoon.ui.theme.caption4SemiBold
import com.example.kakaowebtoon.ui.theme.head1SemiBold
import com.example.kakaowebtoon.ui.theme.head2Bold
import com.example.kakaowebtoon.ui.theme.title1ExtraBold
import com.example.kakaowebtoon.ui.theme.title2SemiBold
import com.example.kakaowebtoon.ui.theme.title3SemiBold
import com.example.kakaowebtoon.ui.theme.title4SemiBold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KakaoWebtoonTheme {
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
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = head1SemiBold
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = head2Bold
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = title1ExtraBold
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = title2SemiBold
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = title3SemiBold
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = title4SemiBold
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = body1Regular
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = body2Regular
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = body3Regular
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = body4SemiBold
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = body5Regular
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = body6Regular
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = caption1Bold
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = caption2Medium
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = caption3Light
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = caption4SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KakaoWebtoonTheme {
        Greeting("Android")
    }
}