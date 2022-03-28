package com.gaur.domain.repository


import com.gaur.domain.model.Post

interface GetPostsRepository {

    suspend fun getPosts(): List<Post>


}