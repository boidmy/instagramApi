package com.example.instagramapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagramapi.data.model.InstagramModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    //데이터 캡슐화 필수
    private var _data: LiveData<InstagramModel> = repository.getApi()

    val data: LiveData<InstagramModel>
        get() = _data

    override fun onCleared() {
        repository.onCleared()
        super.onCleared()
    }
}