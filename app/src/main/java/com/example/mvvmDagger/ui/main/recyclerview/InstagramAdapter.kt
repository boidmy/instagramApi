package com.example.mvvmDagger.ui.main.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmDagger.R
import com.example.mvvmDagger.common.diffUtil.DiffUtilCallBack
import com.example.mvvmDagger.common.diffUtil.DiffUtilDataInterface
import com.example.mvvmDagger.data.model.InstagramUser
import com.example.mvvmDagger.data.model.InstagramUserNumber
import com.example.mvvmDagger.databinding.InstagramItemBinding
import com.example.mvvmDagger.databinding.InstagramItemPhoneBinding
import com.example.mvvmDagger.ui.base.ViewHolderBase
import com.example.mvvmDagger.ui.main.MainViewModel

class InstagramAdapter(private val viewModel: MainViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val USER = 0
    private val NUMBER = 1

    private val diffUtil = AsyncListDiffer(this, DiffUtilCallBack)

    var getUser: (Int) -> InstagramUser = {
        diffUtil.currentList.getOrNull(it) as InstagramUser
    }

    var getUserNumber: (Int) -> InstagramUserNumber = {
        diffUtil.currentList.getOrNull(it) as InstagramUserNumber
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            USER -> InstagramViewHolder(parent)
            else -> InstagramNumberViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is InstagramViewHolder -> {
                holder.bindView(getUser(position)) {
                    viewModel.clickItem(position, diffUtil.currentList)
                }
            }
            is InstagramNumberViewHolder -> holder.bindView(getUserNumber(position))
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
        diffUtil.submitList(data as List<DiffUtilDataInterface>)
    }
}

class InstagramViewHolder(parent: ViewGroup) :
    ViewHolderBase<InstagramItemBinding>(parent, R.layout.instagram_item) {

    fun bindView(item: InstagramUser, block: () -> Unit) {
        binding.item = item
        binding.container.setOnClickListener {
            block()
        }
    }
}

class InstagramNumberViewHolder(parent: ViewGroup) :
    ViewHolderBase<InstagramItemPhoneBinding>(parent, R.layout.instagram_item_phone) {

    fun bindView(item: InstagramUserNumber) {
        binding.item = item
    }
}