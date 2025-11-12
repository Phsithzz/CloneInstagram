package com.example.cloneinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cloneinstagram.ui.theme.CloneinstagramTheme

data class User(
    val profile: String,
    val name: String
)

data class Profile(
    val user: User,
    val post: String,
    val description: String,
    val likesCount: Int,
    val commentsCount: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CloneinstagramTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddings ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddings)
                    ) {
                        TopBar()

                    }
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 14.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ) {

        Icon(modifier = Modifier.height(40.dp),
            painter = painterResource(id = R.drawable.instagram),
            contentDescription = "IconInstagram"
        )

        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
            Icon(modifier = Modifier
                .size(30.dp),
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = "IconHeart"
                )
            Spacer(modifier = Modifier.width(30.dp))
            Icon(modifier = Modifier
                .size(30.dp),
                painter = painterResource(id = R.drawable.ic_comment),
                contentDescription = "IconHeart"
            )
        }
    }
}

@Composable
fun StoryList(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 10.dp)
    ){

    }
}
