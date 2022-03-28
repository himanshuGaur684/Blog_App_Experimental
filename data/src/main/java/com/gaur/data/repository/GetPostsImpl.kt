package com.gaur.data.repository

import com.gaur.data.network.ApiService
import com.gaur.data.network.utils.SafeApiRequest
import com.gaur.data.mappers.toDomainPosts
import com.gaur.domain.model.Post
import com.gaur.domain.repository.GetPostsRepository
import javax.inject.Inject

class GetPostsImpl @Inject constructor(private val apiService: ApiService) : GetPostsRepository, SafeApiRequest() {
    override suspend fun getPosts(): List<Post> {
        val response = safeApiRequest { apiService.getPosts() }
        val domainPosts = response.toDomainPosts()
        return domainPosts
    }
}