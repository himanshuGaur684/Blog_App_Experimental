package com.gaur.data.network.di

import com.gaur.common.Constants
import com.gaur.data.network.ApiService
import com.gaur.data.repository.GetPostDetailsImpl
import com.gaur.data.repository.GetPostsImpl
import com.gaur.domain.repository.GetPostDetailsRepository
import com.gaur.domain.repository.GetPostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }


    @Provides
    fun provideGetRepository(apiService: ApiService): GetPostsRepository {
        return GetPostsImpl(apiService = apiService)
    }


    @Provides
    fun provideDetailsRepository(apiService: ApiService): GetPostDetailsRepository {
        return GetPostDetailsImpl(apiService = apiService)
    }


}