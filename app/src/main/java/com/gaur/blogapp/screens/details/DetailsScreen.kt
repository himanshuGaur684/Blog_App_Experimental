package com.gaur.blogapp.screens.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gaur.blogapp.screens.home.PostItem
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun DetailsScreen(id: String, viewModel: DetailsViewModel) {

    val post = viewModel.post.value

    if (post.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
    if (post.error.isNotEmpty()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "Some error Occurred", modifier = Modifier.align(Alignment.Center))
        }
    }
    post.data?.let {
        Column(modifier = Modifier.fillMaxSize()) {
            PostItem(post = post.data) {}
            Text(
                modifier = Modifier.padding(12.dp),
                text = "${post.data.likes} Likes",
                style = TextStyle(color = Color.Gray, fontSize = 14.sp)
            )


            FlowRow() {
                post.data.tags.forEach {
                    TagItem(it)
                }
            }

        }


    }

}

@Preview
@Composable
fun TagItem(it: String = "Himanshu") {

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(4.dp),
        backgroundColor = MaterialTheme.colors.background,
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(0.5.dp, color = Color.DarkGray)
    ) {
        Text(
            text = it,
            style = TextStyle(color = Color.Black, fontSize = 18.sp),
            modifier = Modifier.padding(8.dp)
        )
    }


}
