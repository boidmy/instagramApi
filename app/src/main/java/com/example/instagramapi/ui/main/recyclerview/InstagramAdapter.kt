package com.example.instagramapi.ui.main.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramapi.R
import com.example.instagramapi.common.DiffUtilCallBack
import com.example.instagramapi.common.diffUtil.DiffUtilDataInterface
import com.example.instagramapi.data.model.InstagramModel
import com.example.instagramapi.data.model.InstagramUser
import com.example.instagramapi.databinding.InstagramItemBinding
import com.example.instagramapi.ui.base.ViewHolderBase
import com.example.instagramapi.ui.main.MainViewModel

class InstagramAdapter(viewModel: MainViewModel): RecyclerView.Adapter<InstagramViewHolder>() {

    private val diffUtil = AsyncListDiffer(this, DiffUtilCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstagramViewHolder {
        return InstagramViewHolder(parent)
    }

    override fun onBindViewHolder(holder: InstagramViewHolder, position: Int) {
        holder.bindView(diffUtil.currentList[position] as InstagramUser)
    }

    override fun getItemCount(): Int {
        return diffUtil.currentList.size
    }

    fun setData(data: InstagramModel) {
        val item: MutableList<InstagramUser> = mutableListOf()
        item.addAll(data.contacts)
        diffUtil.submitList(item as List<DiffUtilDataInterface>)
    }
}

class InstagramViewHolder(parent: ViewGroup): ViewHolderBase<InstagramItemBinding>(parent, R.layout.instagram_item) {

    fun bindView(item: InstagramUser) {
        binding.email.text = item.email
        binding.id.text = item.id
    }
}