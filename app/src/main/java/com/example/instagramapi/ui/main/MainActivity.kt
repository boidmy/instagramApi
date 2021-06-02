package com.example.instagramapi.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.instagramapi.R
import com.example.instagramapi.databinding.ActivityMainBinding
import com.example.instagramapi.ui.base.BaseActivity
import com.example.instagramapi.ui.main.recyclerview.InstagramAdapter
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<MainViewModel> {factory}

    override val layout: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
        binding.instagramRv.adapter = InstagramAdapter(viewModel)

        viewModel.data.observe(this, Observer {
            (binding.instagramRv.adapter as InstagramAdapter).setData(it)
        })
    }
}