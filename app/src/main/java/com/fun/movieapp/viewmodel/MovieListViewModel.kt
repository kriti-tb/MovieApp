package com.`fun`.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.`fun`.movieapp.data.repository.MainRepository
import com.`fun`.movieapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class MovieListViewModel (private val mainRepository: MainRepository) : ViewModel() {

        fun getMovieList() = liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(Resource.success(data = mainRepository.getMovieList()))
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }
    }
