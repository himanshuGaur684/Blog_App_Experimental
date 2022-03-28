package com.gaur.domain.repository

import com.gaur.domain.model.Post

interface GetPostDetailsRepository {

    suspend fun getPostDetails(id:String) : Post

}