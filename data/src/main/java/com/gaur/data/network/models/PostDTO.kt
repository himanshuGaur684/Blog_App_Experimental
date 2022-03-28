package com.gaur.data.network.models

data class PostDTO(
    val id: String?=null,
    val image: String?=null,
    val likes: Int?=null,
    val owner: OwnerDTO?=null,
    val publishDate: String?=null,
    val tags: List<String>?=null,
    val text: String?=null
)