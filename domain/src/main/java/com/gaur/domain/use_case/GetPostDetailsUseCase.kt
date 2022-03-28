package com.gaur.domain.use_case

import android.util.Log
import com.gaur.common.Resource
import com.gaur.domain.model.Post
import com.gaur.domain.repository.GetPostDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class GetPostDetailsUseCase @Inject constructor(private val getPostDetailsRepository: GetPostDetailsRepository) {

     operator fun invoke(id:String): Flow<Resource<Post>> = flow {
        emit(Resource.Loading(message="loading"))
        try {
            val response = getPostDetailsRepository.getPostDetails(id)
            Log.d("TAG", "invoke: $response")
            emit(Resource.Success(response))
        }catch (e:Exception){
            emit(Resource.Error(message= "Error Occurred!!"))
        }
    }






}