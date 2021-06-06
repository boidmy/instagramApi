package com.example.mvvmDagger.di.module

import com.example.mvvmDagger.ui.main.MainActivity
import com.example.mvvmDagger.di.custom.ActivityScope
import com.example.mvvmDagger.ui.main.MainActivityModule
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