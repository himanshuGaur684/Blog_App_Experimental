package com.gaur.data.network

import com.gaur.common.Constants
import com.gaur.data.network.models.PostDTO
import com.gaur.data.network.models.PostsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {

    @GET("post")
    suspend fun getPosts(
        @Header("app-id") key: String = Constants.KEY): Response<PostsDTO>

    @GET("post/{id}")
    suspend fun getPost(
        @Header("app-id") key: String=Constants.KEY ,
        @Path("id") id: String): Response<PostDTO>

}