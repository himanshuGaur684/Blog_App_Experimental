package com.gaur.blogapp.screens.home

import com.gaur.domain.model.Post

data class HomeState(
    val isLoading:Boolean=false,
    val data:List<Post> ?=null,
    val error:String = ""
)
