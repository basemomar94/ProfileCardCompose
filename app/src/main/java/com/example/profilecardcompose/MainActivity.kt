package com.example.profilecardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
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
            Column() {
                val user1 = User("bassem","active",R.drawable.profile_bassem)
                val user2 = User("hadeer","away",R.drawable.profile_bassem)
                val user3 = User("Ronlado","active",R.drawable.profile_bassem)
                val user4 = User("Radwa","away",R.drawable.profile_bassem)
                val user5 = User("Hany","active",R.drawable.profile_bassem)
                val user6 = User("hadeer","away",R.drawable.profile_bassem)
                val userList = listOf(user1,user2,user3,user4,user5,user6)
                LazyColumn{
                   items(items = userList, itemContent = {user->
                       ProfileCard(user = user)
                       
                   })

                }
            }

        }


}

@Composable
fun AppBar() {
    TopAppBar(navigationIcon = {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "",
            modifier = Modifier.padding(8.dp)
        )
    }, title = {
        Text(
            text = "card app"
        )
    })
}

@Composable
fun ProfileCard(user: User) {
    Card(elevation = 8.dp, backgroundColor = Color.Green, modifier = Modifier.wrapContentSize()) {
        Row(
            modifier = Modifier
                .height(60.dp)
                .width(250.dp)
                .padding(8.dp)
                .wrapContentWidth()
        ) {
            ProfilePhoto(user)
            Spacer(modifier = Modifier.width(8.dp))
            ProfileContent(user)
        }
    }

}

@Composable
fun ProfilePhoto(user: User) {
    Card(
        elevation = 8.dp,
        modifier = Modifier.wrapContentWidth()
    ) {
        Image(
            painter = painterResource(id = user.image),
            contentDescription = "",
            modifier = Modifier.size(72.dp)
        )
    }

}

@Composable
fun ProfileContent(user: User) {
    Column() {
        Text(user.name, style = MaterialTheme.typography.body1)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            Text(user.status, style = MaterialTheme.typography.body2)

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