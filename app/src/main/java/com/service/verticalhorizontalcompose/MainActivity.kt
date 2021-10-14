package com.service.verticalhorizontalcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.service.verticalhorizontalcompose.ui.theme.Purple500
import com.service.verticalhorizontalcompose.ui.theme.VerticalHorizontalComposeTheme
import com.service.verticalhorizontalcompose.ui.theme.lightGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VerticalHorizontalComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    VerticalHorizontalScroll()
                }
            }
        }
    }
}

@Composable
fun VerticalHorizontalScroll() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Purple500),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Compose Nested Scrollview",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn {
            item {
                Text(
                    text = "Recent List",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }

            //Horizontal Scroll view
            item {
                LazyRow {
                    items(count = 10) {
                        Card(
                            modifier = Modifier
                                .width(110.dp)
                                .height(120.dp)
                                .padding(10.dp, 5.dp, 5.dp, 0.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White),
                            elevation = 5.dp
                        ) {
                            Column(
                                modifier = Modifier.padding(5.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.cat),
                                    contentDescription = "profile Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                )

                                Spacer(modifier = Modifier.padding(5.dp))

                                Text(
                                    text = "Test",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Lists",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }

            items(count = 10) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(10.dp, 5.dp, 10.dp, 5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White),
                    elevation = 5.dp
                ) {
                   Column(
                       modifier = Modifier.padding(10.dp)
                   ) {
                       Row(
                           verticalAlignment = Alignment.CenterVertically
                       ) {
                           Image(
                               painter = painterResource(id = R.drawable.cat),
                               contentDescription = "Profile Image",
                               contentScale = ContentScale.Crop,
                               modifier = Modifier
                                   .size(60.dp)
                                   .clip(CircleShape)
                           )

                           Spacer(modifier = Modifier.padding(5.dp))

                           Column {
                               Text(
                                   text = "Sample Test",
                                   color = Color.Black,
                                   fontSize = 16.sp,
                                   fontWeight = FontWeight.Bold
                               )

                               Spacer(modifier = Modifier.padding(2.dp))

                               Text(
                                   text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                                   color = Color.Gray,
                                   fontSize = 12.sp
                               )
                           }
                       }
                   }
                }
            }
        }
    }
}






















