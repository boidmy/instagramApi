package com.example.mvvmDagger.common.diffUtil

import androidx.recyclerview.widget.DiffUtil

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
