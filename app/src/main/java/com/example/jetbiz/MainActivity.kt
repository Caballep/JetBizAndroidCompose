package com.example.jetbiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbiz.ui.theme.JetBizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {

    val buttonClickState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(15.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateProfileContainer()
                Divider(
                    thickness = 1.dp,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                CreateProfileInfo()
                Button(onClick = {
                    buttonClickState.value = !buttonClickState.value
                }) {
                    Text(text = "Click Me")
                }
                if (buttonClickState.value) {
                    CreateList()
                } else {
                    Box() {

                    }
                }
            }
        }
    }
}

@Composable
private fun CreateProfileContainer() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(20.dp),
        shape = CircleShape,
        border = BorderStroke(width = 3.dp, color = Color.Gray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun CreateProfileInfo() {
    Text(
        text = "Aline Jolina",
        color = MaterialTheme.colors.primary,
        fontSize = 30.sp
    )
    Text(text = "caradehuelepedo@gmail.com")
    Text(text = "47077696969")
}

@Composable
private fun CreateList() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            border = BorderStroke(width = 2.dp, color = Color.Blue)
        ) {
            Portfolio(data = listOf("HP Omen", "Fire with Fire", "Nike", "I don't know!", "Taco Taco"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 10.dp)) {
        items(data) { i ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(10.dp),
                border = BorderStroke(width = 1.dp, color = Color.DarkGray)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = i,
                        textAlign = TextAlign.Center,
                        fontSize = 28.sp,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Text("Some other text 1", modifier = Modifier.padding(top = 2.dp, bottom = 5.dp))
                    Text("Some other text 2", modifier = Modifier.padding(top = 2.dp, bottom = 5.dp))
                    Text("Some other text 3", modifier = Modifier.padding(top = 2.dp, bottom = 5.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizTheme {
        //CreateBizCard()
        CreateList()
    }
}
