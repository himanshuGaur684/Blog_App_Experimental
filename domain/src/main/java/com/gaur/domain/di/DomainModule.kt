package com.gaur.domain.di

import com.gaur.domain.repository.GetPostDetailsRepository
import com.gaur.domain.repository.GetPostsRepository
import com.gaur.domain.use_case.GetPostDetailsUseCase
import com.gaur.domain.use_case.GetPostListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DomainModule {


   @Provides
   fun provideGetPostUseCase(getPostsRepository: GetPostsRepository):GetPostListUseCase{
       return GetPostListUseCase(getPostsRepository)
   }


    @Provides
    fun providePostDetailsUseCase(getPostDetailsRepository: GetPostDetailsRepository):GetPostDetailsUseCase{
        return GetPostDetailsUseCase(getPostDetailsRepository)
    }



}