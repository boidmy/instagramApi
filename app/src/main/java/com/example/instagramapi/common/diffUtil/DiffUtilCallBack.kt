package com.example.instagramapi.common.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.instagramapi.common.diffUtil.DiffUtilDataInterface
import com.example.instagramapi.common.diffUtil.DiffUtilSelectorDataInterface

object DiffUtilCallBack: DiffUtil.ItemCallback<DiffUtilDataInterface>() {
    override fun areItemsTheSame(oldItem: DiffUtilDataInterface, newItem: DiffUtilDataInterface): Boolean {
        return oldItem.keyValue() == newItem.keyValue()
    }

    override fun areContentsTheSame(
        oldItem: DiffUtilDataInterface,
        newItem: DiffUtilDataInterface
    ): Boolean {
        return if (oldItem.contentValue() == newItem.contentValue()) {
            oldItem.itemIndex() == newItem.itemIndex()
        } else {
            false
        }
    }
}

object DiffUtilSelectorCallBack: DiffUtil.ItemCallback<DiffUtilSelectorDataInterface>() {
    override fun areItemsTheSame(oldItem: DiffUtilSelectorDataInterface, newItem: DiffUtilSelectorDataInterface): Boolean {
        return oldItem.keyValue() == newItem.keyValue()
    }

    override fun areContentsTheSame(
        oldItem: DiffUtilSelectorDataInterface,
        newItem: DiffUtilSelectorDataInterface
    ): Boolean {
        return oldItem.contentSelectorValue() == newItem.contentSelectorValue()
    }
}
