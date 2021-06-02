package com.example.instagramapi.data.apiConnect

import com.example.instagramapi.data.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnection private constructor() {

    private val retrofit: Retrofit

    private val baseUrl = "https://api.androidhive.info/"

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {

        private val INSTANCE = ApiConnection()

        fun instance(): ApiConnection {
            return INSTANCE
        }
    }

    val apiService: ApiService
        get() = retrofit.create(ApiService::class.java)
}
