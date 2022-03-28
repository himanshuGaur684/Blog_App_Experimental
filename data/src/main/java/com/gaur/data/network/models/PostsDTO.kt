package com.gaur.data.network.models

data class PostsDTO(
    val `data`: List<PostDTO>?=null,
    val limit: Int?=null,
    val page: Int?=null,
    val total: Int?=null
)