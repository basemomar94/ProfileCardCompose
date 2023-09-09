package com.example.profilecardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilecardcompose.ui.theme.ProfileCardComposeTheme
import com.example.profilecardcompose.ui.theme.teal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCardComposeTheme {
                MainScreen()
            }
        }
    }
}


@Composable
fun MainScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.teal) {

        ProfileCard()
    }
}

@Composable
fun ProfileCard() {
    Card(elevation = 8.dp, backgroundColor = Color.Green, modifier = Modifier.wrapContentSize()) {
        Row(
            modifier = Modifier
                .height(60.dp)
                .width(250.dp)
                .padding(8.dp).wrapContentWidth()
        ) {
            ProfilePhoto()
            Spacer(modifier = Modifier.width(8.dp))
            ProfileContent()
        }
    }

}

@Composable
fun ProfilePhoto() {
    Card(
        elevation = 8.dp,
        modifier = Modifier.wrapContentWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_bassem),
            contentDescription = "",
            modifier = Modifier.size(72.dp)
        )
    }

}

@Composable
fun ProfileContent() {
    Column() {
        Text("Bassem Omar", style = MaterialTheme.typography.body1)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            Text("Active Now", style = MaterialTheme.typography.body2)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileCardComposeTheme {
        MainScreen()
    }
}