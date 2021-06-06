package com.example.mvvmDagger.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private var _data: LiveData<List<Any>> = repository.getApi()

    val data: LiveData<List<Any>>
        get() = _data

    fun clickItem(position: Int, itemList: List<Any>) {
        repository.clickItem(position, itemList)
    }

    override fun onCleared() {
        repository.onCleared()
        super.onCleared()
    }
}