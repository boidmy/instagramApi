package com.example.instagramapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.instagramapi.data.apiConnect.ApiConnection
import com.example.instagramapi.data.model.InstagramModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainRepository @Inject constructor() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    var data: MutableLiveData<InstagramModel> = MutableLiveData()

    fun getApi(): LiveData<InstagramModel> {
        disposable.add(
            ApiConnection.instance()
            .apiService.getAPI()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data.value = it
            }, {
                //통신에러
            })
        )
        return data
    }

    fun onCleared() {
        disposable.dispose()
    }
}