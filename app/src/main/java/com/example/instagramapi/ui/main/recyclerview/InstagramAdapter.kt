package com.example.instagramapi.ui.main.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramapi.R
import com.example.instagramapi.common.diffUtil.DiffUtilCallBack
import com.example.instagramapi.common.diffUtil.DiffUtilDataInterface
import com.example.instagramapi.data.model.InstagramUser
import com.example.instagramapi.data.model.InstagramUserNumber
import com.example.instagramapi.databinding.InstagramItemBinding
import com.example.instagramapi.databinding.InstagramItemPhoneBinding
import com.example.instagramapi.ui.base.ViewHolderBase
import com.example.instagramapi.ui.main.MainViewModel

class InstagramAdapter(private val viewModel: MainViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffUtil = AsyncListDiffer(this, DiffUtilCallBack)
    private val USER = 0
    private val NUMBER = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            USER -> InstagramViewHolder(parent)
            else -> InstagramNumberViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is InstagramViewHolder -> {
                holder.bindView(diffUtil.currentList.getOrNull(position) as InstagramUser) {
                    viewModel.clickItem(position, diffUtil.currentList)
                }
            }
            is InstagramNumberViewHolder -> holder.bindView(diffUtil.currentList.getOrNull(position) as InstagramUserNumber)
        }
    }

    override fun getItemCount(): Int {
        return diffUtil.currentList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (diffUtil.currentList.getOrNull(position)?.itemType()) {
            "user" -> USER
            else -> NUMBER
        }
    }

    fun setData(data: List<Any>) {
        val item: MutableList<Any> = mutableListOf()
        item.addAll(data)
        diffUtil.submitList(item as List<DiffUtilDataInterface>)
    }
}

class InstagramViewHolder(parent: ViewGroup) :
    ViewHolderBase<InstagramItemBinding>(parent, R.layout.instagram_item) {

    fun bindView(item: InstagramUser, block: () -> Unit) {
        binding.email.text = item.email
        binding.id.text = item.id
        binding.container.setOnClickListener {
            block()
        }
    }
}

class InstagramNumberViewHolder(parent: ViewGroup) :
    ViewHolderBase<InstagramItemPhoneBinding>(parent, R.layout.instagram_item_phone) {

    fun bindView(item: InstagramUserNumber) {
        binding.mobile.text = item.mobile
        binding.home.text = item.home
        binding.office.text = item.office

    }
}