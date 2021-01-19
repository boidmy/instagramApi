package com.example.instagramapi.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    //데이터 캡슐화 필수
    private var data: MutableLiveData<Any> = MutableLiveData()

    fun getApi(): MutableLiveData<Any> {
        data = repository.getApi()
        return data
    }

    override fun onCleared() {
        repository.onCleared()
        super.onCleared()
    }
}