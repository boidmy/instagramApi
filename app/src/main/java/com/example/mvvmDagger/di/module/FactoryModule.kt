package com.example.mvvmDagger.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.mvvmDagger.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class FactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}