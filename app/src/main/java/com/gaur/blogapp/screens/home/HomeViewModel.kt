package com.gaur.blogapp.screens.home


import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.common.Resource
import com.gaur.domain.use_case.GetPostListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPostListUseCase: GetPostListUseCase): ViewModel() {

    private val _posts: MutableState<HomeState> = mutableStateOf(HomeState())
    val posts: State<HomeState> = _posts


    init {
        getPosts()
    }

    fun getPosts() {
        getPostListUseCase().onEach {
            when(it){
                is Resource.Loading->{ _posts.value = HomeState(isLoading = true)}
                is Resource.Error->{_posts.value = HomeState(error = it.message.toString())}
                is Resource.Success->{_posts.value = HomeState(data= it.data)}
            }
        }.launchIn(viewModelScope)
    }


}