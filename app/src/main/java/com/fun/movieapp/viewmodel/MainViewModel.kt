package com.`fun`.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.`fun`.movieapp.data.repository.MainRepository
import com.`fun`.movieapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {



    fun getMovie() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data   = null))
        try {
            emit(Resource.success(data = mainRepository.getMovieInfo1()))
        } catch (exception: Exception) {
           // emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }

    /*fun getReviewInfo() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data   = null))
        try {
            emit(Resource.success(data = mainRepository.getReview()))
        } catch (exception: Exception) {
           // emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    } */
}
