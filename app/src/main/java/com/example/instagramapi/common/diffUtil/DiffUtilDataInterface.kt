package com.example.instagramapi.common.diffUtil


interface DiffUtilDataInterface {

    fun keyValue(): String
    fun contentValue(): String
    fun itemType(): String
    fun itemIndex(): String
    fun setItemIndex(index: Int)
}