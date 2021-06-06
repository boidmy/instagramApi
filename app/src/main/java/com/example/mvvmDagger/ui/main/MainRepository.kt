package com.example.mvvmDagger.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmDagger.common.diffUtil.DiffUtilDataInterface
import com.example.mvvmDagger.data.apiConnect.ApiConnection
import com.example.mvvmDagger.data.model.InstagramModel
import com.example.mvvmDagger.data.model.InstagramUser
import com.example.mvvmDagger.data.model.InstagramUserNumber
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
                //error
            })
        )
        return data
    }

    fun clickItem(position: Int, itemList: List<Any>) {
        val list: List<Any> = itemList.map {
            when (it) {
                is InstagramUser -> {
                    if (position == it.index) {
                        it.copy(itemClick = !it.itemClick)
                    } else {
                        it.copy()
                    }
                }
                is InstagramUserNumber -> it.copy()
                else -> it
            }
        }

        with(list[position] as InstagramUser) {
            if (itemClick) {
                (list as MutableList).add(position+1, phone)
            } else {
                (list as MutableList).removeAt(position+1)
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