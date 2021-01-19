package com.example.instagramapi.di.module

import com.example.instagramapi.ui.main.MainActivity
import com.example.instagramapi.di.custom.ActivityScope
import com.example.instagramapi.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainActivityModule::class
    ])
    abstract fun mainActivity(): MainActivity
}