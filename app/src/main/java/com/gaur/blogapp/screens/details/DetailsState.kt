package com.gaur.blogapp.screens.details

import com.gaur.domain.model.Post

data class DetailsState(
    val isLoading:Boolean = false,
    val data: Post?=null,
    val error:String=""
)
