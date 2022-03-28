package com.gaur.blogapp.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.common.Resource
import com.gaur.domain.use_case.GetPostDetailsUseCase
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getPostDetailsUseCase: GetPostDetailsUseCase,
    savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _post: MutableState<DetailsState> = mutableStateOf(DetailsState())
    val post: State<DetailsState> = _post



    init {
       savedStateHandle.getLiveData<String>("blogId").value?.let { getPostDetails(it) }
    }


    fun getPostDetails(id: String) {
        getPostDetailsUseCase(id).onEach {
        when(it){
            is Resource.Loading->{
                _post.value = DetailsState(isLoading = true)
            }
            is Resource.Success->{
                _post.value = DetailsState(data = it.data)
            }
            is Resource.Error->{
                _post.value = DetailsState(error=it.message.toString())
            }
        }
        }.launchIn(viewModelScope)
    }

}