package com.example.instagramapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.instagramapi.common.diffUtil.DiffUtilDataInterface
import com.example.instagramapi.data.apiConnect.ApiConnection
import com.example.instagramapi.data.model.InstagramModel
import com.example.instagramapi.data.model.InstagramUser
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainRepository @Inject constructor() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    var data: MutableLiveData<List<Any>> = MutableLiveData()

    fun getApi(): LiveData<List<Any>> {
        disposable.add(
            ApiConnection.instance()
            .apiService.getAPI()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.setItemIndex()
                data.value = it.contacts
            }, {
                //통신에러
            })
        )
        return data
    }

    fun clickItem(position: Int, itemList: List<Any>) {
        val list: MutableList<Any> = mutableListOf()
        list.addAll(itemList)
        with(list[position] as InstagramUser) {
            itemClick = if (itemClick) {
                list.removeAt(position+1)
                false
            } else {
                list.add(position+1, phone)
                true
            }
        }
        for ((index, item) in list.withIndex()) {
            (item as DiffUtilDataInterface).setItemIndex(index)
        }
        data.value = list
    }

    fun onCleared() {
        disposable.dispose()
    }
}