package com.example.instagramapi.data

import com.example.instagramapi.data.model.InstagramModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("contacts")
    fun getAPI(): Observable<InstagramModel>
}