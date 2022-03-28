package com.gaur.domain.use_case

import com.gaur.common.Resource
import com.gaur.domain.model.Post
import com.gaur.domain.repository.GetPostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetPostListUseCase @Inject constructor(private val getPostsRepository: GetPostsRepository) {

     operator fun  invoke(): Flow<Resource<List<Post>>> = flow {
         emit(Resource.Loading(""))
         try {
             emit(Resource.Success(getPostsRepository.getPosts()))
         }catch (e:Exception){
             emit(Resource.Error("error occurred"))
         }
    }


}