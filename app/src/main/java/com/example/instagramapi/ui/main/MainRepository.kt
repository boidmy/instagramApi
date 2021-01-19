package com.example.instagramapi.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.instagramapi.data.ApiConnection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainRepository @Inject constructor() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    var data: MutableLiveData<Any> = MutableLiveData()

    fun getApi(): MutableLiveData<Any> {
        disposable.add(
            ApiConnection.instance()
            .apiService.getAPI()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("dd", it.toString())
                data.value = it
            }, {
                Log.d("오류", it.toString())
            })
        )
        return data
    }

    fun onCleared() {
        disposable.dispose()
    }
}