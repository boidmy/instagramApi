package com.example.mvvmDagger.data

import com.example.mvvmDagger.data.model.UserModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("contacts")
    fun getAPI(): Observable<UserModel>
}