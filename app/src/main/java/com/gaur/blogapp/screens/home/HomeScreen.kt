package com.gaur.blogapp.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.gaur.domain.model.Post


@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val res = viewModel.posts.value

    Log.d("TAG", "HomeScreen: ${viewModel.posts.value.toString()}")

    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(modifier = Modifier.align(Alignment.Center), text = res.error.toString())
        }
    }

    LazyColumn {
        viewModel.posts.value.data?.let {
            items(it) {
                PostItem(post = it) { id ->
                    navController.navigate("blog_details/${id}")
                }
            }
        }
    }
}


@Composable
fun PostItem(post: Post, blogId: (String) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            blogId.invoke(post.id)
        }, verticalArrangement = Arrangement.Center) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), verticalAlignment = Alignment.CenterVertically
        ) {

            CircularImage(
                width = 50.0,
                height = 50.0,
                radius = 25.0,
                imageUrl = post.owner.picture!!
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                modifier = Modifier,
                text = "${post.owner.firstName} ${post.owner.lastName}",
                style = TextStyle(color = Color.Black, fontWeight = FontWeight.SemiBold)
            )

        }

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(top = 8.dp),
            painter = rememberImagePainter(data = post.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier.padding(12.dp),
            text = post.text,
            style = TextStyle(color = Color.DarkGray, fontSize = 20.sp)
        )

        Divider(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
        )

    }


}


@Composable
fun CircularImage(width: Double, height: Double, radius: Double, imageUrl: String) {
    Card(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp),
        shape = RoundedCornerShape(radius.dp),
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = rememberImagePainter(data = imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }


}
