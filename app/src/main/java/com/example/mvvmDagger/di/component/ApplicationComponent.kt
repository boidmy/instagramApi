package com.example.mvvmDagger.di.component

import android.app.Application
import com.example.mvvmDagger.MainApplication
import com.example.mvvmDagger.di.module.ActivityBindingModule
import com.example.mvvmDagger.di.module.FactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityBindingModule::class,
        FactoryModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MainApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}