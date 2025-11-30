package com.example.cloneinstagram

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cloneinstagram.ui.theme.CloneinstagramTheme
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


data class User(
    val profile: Int,
    val name: String
)

data class Post(
    val user: User,
    val post: Int,
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
                Scaffold(
                    topBar = {
                        TopBar()
                    },
                    bottomBar = {
                        BottomBar()
                    }
                ) { paddings ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddings)
                    ) {
                        val stories = listOf(
                        User(
                            profile=R.drawable.profile,
                            name="A"
                        ),
                        User(
                            profile=R.drawable.profile,
                            name="B"
                        ),
                        User(
                            profile=R.drawable.profile,
                            name="C"
                        ),
                        User(
                            profile=R.drawable.profile,
                            name="D"
                        ),
                        User(
                            profile=R.drawable.profile,
                            name="E"
                        ),
                        User(
                            profile=R.drawable.profile,
                            name="F"
                        ),
                            User(
                                profile=R.drawable.profile,
                                name="G"
                            ),
                        )


                        val posts = listOf(
                            Post(
                                user = stories[0],
                                post=R.drawable.profile,
                                description = "Coffee first, code later  #developerlife",
                                likesCount = (100..10000).random(),
                                commentsCount = (100..10000).random()
                        ),
                        Post(
                            user = stories[1],
                            post=R.drawable.profile,
                            description = "Coffee first, code later  #developerlife",
                            likesCount = (100..10000).random(),
                            commentsCount = (100..10000).random()
                        ),
                        Post(
                            user = stories[2],
                            post=R.drawable.profile,
                            description = "Coffee first, code later  #developerlife",
                            likesCount = (100..10000).random(),
                            commentsCount = (100..10000).random()
                        ),
                        Post(
                            user = stories[3],
                            post=R.drawable.profile,
                            description = "Coffee first, code later  #developerlife",
                            likesCount = (100..10000).random(),
                            commentsCount = (100..10000).random()
                        ),
                        Post(
                            user = stories[4],
                            post=R.drawable.profile,
                            description = "Coffee first, code later  #developerlife",
                            likesCount = (100..10000).random(),
                            commentsCount = (100..10000).random()
                        ),
                        Post(
                            user = stories[5],
                            post=R.drawable.profile,
                            description = "Coffee first, code later  #developerlife",
                            likesCount = (100..10000).random(),
                            commentsCount = (100..10000).random()
                        ),
                        Post(
                            user = stories[6],
                            post=R.drawable.profile,
                            description = "Coffee first, code later  #developerlife",
                            likesCount = (100..10000).random(),
                            commentsCount = (100..10000).random()
                        ),
                        )
                        Posts(stories = stories,posts=posts)

                    }
                }
            }
        }
    }
}
@Composable
fun Posts(
    stories:List<User>,
    posts:List<Post>
) {
    val context = LocalContext.current
    LazyColumn(
        modifier=Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            Stories(stories = stories)
        }
        items(posts){ post->
            var liked by remember {
                mutableStateOf(false)
            }
            LaunchedEffect(liked){
                if (liked){
                    delay(2000)
                    liked = false
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 1.dp, horizontal = 8.dp
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier
                        .border(
                            3.dp, Brush.horizontalGradient(
                                listOf(
                                    Color(0xffff6f00),
                                    Color(0xffffeb35),
                                    Color(0xffff6f00),
                                    Color(0xffff2b99),
                                    Color(0xffff2bd1),
                                    Color(0xffff2bd1),
                                )
                            ), CircleShape
                        )
                        .size(33.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            modifier = Modifier.size(30.dp).clip(CircleShape),
                            painter = painterResource(id=post.user.profile),
                            contentDescription = "${post.user.name} Profile",
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = post.user.name)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.pointerInput(Unit) {
                detectTapGestures(onDoubleTap = {
                    liked = true
                })
            }, contentAlignment = Alignment.Center){
                Image(
                    modifier = Modifier.fillMaxWidth() .aspectRatio(1f),

                    painter = painterResource(id=post.post),
                    contentDescription = "${post.post} Profile",
                    contentScale = ContentScale.Crop
                )
                androidx.compose.animation.AnimatedVisibility(visible=liked,enter= scaleIn(spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                ))){
                    Image(
                        modifier=Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp, horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val iconsModifier=Modifier.size(20.dp)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Icon(
                        modifier=iconsModifier,
                        painter = painterResource(id = R.drawable.ic_heart),
                        contentDescription = null
                    )
                    Icon(
                        modifier=iconsModifier,
                        painter = painterResource(id = R.drawable.ic_comment),
                        contentDescription = null
                    )
                    Icon(
                        modifier=iconsModifier,
                        painter = painterResource(id = R.drawable.ic_send),
                        contentDescription = null
                    )
                }
                Icon(
                    modifier=iconsModifier,
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(text = "${post.likesCount} likes", fontSize = 13.sp)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = post.description, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = "View all ${post.commentsCount} comments", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}


@Composable
fun Stories(stories:List<User>){
    val context = LocalContext.current

    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        itemsIndexed(stories){index,story->
            if(index == 0){
                Spacer(modifier = Modifier.width(10.dp))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ){
                Box(modifier=Modifier.border(4.dp, Brush.horizontalGradient(
                        listOf(
                            Color(0xfffff6f00),
                            Color(0xfffffeb35),
                            Color(0xfffff6f00),
                            Color(0xfffff2b99),
                            Color(0xfffff2bd1),
                            Color(0xfffff2bd1),
                        )
                    ),CircleShape
                    )
                    .size(70.dp),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        modifier = Modifier.size(66.dp).clip(CircleShape),
                        painter = painterResource(id=story.profile),
                        contentDescription = "${story.name} Profile",
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier=Modifier.height(4.dp))
                Text(text=story.name,fontSize=14.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun TopBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .statusBarsPadding()
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

data class BottomBarItem(
    val iconRes: Int,
    val description: String
)
val bottomBarItems = listOf(
    BottomBarItem(R.drawable.ic_home, "Home"),
    BottomBarItem(R.drawable.ic_search, "Search"),
    BottomBarItem(R.drawable.ic_add, "Add"),
    BottomBarItem(R.drawable.ic_ig, "Reels")
)
@Composable
fun BottomBar(){
    Row(modifier = Modifier
        .fillMaxWidth()

        .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ){
        bottomBarItems.forEach{ item ->
            Icon(
                modifier = Modifier.size(28.dp),
                painter = painterResource(id = item.iconRes),
                contentDescription = item.description
            )
        }
        Image(
            modifier = Modifier.size(30.dp).clip(CircleShape),
            painter = painterResource(id=R.drawable.profile),
            contentDescription = "User Profile",
            contentScale = ContentScale.Crop
        )

    }
}