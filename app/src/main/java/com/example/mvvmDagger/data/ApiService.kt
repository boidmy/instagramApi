package com.example.mvvmDagger.data

import com.example.mvvmDagger.data.model.InstagramModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("contacts")
    fun getAPI(): Observable<InstagramModel>
}