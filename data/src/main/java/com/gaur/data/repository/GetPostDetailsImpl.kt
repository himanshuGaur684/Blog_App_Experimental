package com.gaur.data.repository

import com.gaur.data.mappers.toDomain
import com.gaur.data.network.ApiService
import com.gaur.data.network.utils.SafeApiRequest
import com.gaur.domain.model.Post
import com.gaur.domain.repository.GetPostDetailsRepository
import java.lang.Exception
import javax.inject.Inject

class GetPostDetailsImpl @Inject constructor(private val apiService: ApiService) : GetPostDetailsRepository , SafeApiRequest(){

    override suspend fun getPostDetails(id: String): Post {
        val response = safeApiRequest { apiService.getPost(id=id) }
        return response.toDomain()
    }
}