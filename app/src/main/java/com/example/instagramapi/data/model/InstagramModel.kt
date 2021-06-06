package com.example.instagramapi.data.model

import com.example.instagramapi.common.Interface.ItemClickInterface
import com.example.instagramapi.common.diffUtil.DiffUtilDataInterface

data class InstagramModel(
    val contacts: List<InstagramUser> = mutableListOf()
) {
    fun setItemIndex() {
        for ((index, item) in contacts.withIndex()) {
            item.index = index
        }
    }
}

data class InstagramUser(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val address: String = "",
    val gender: String = "",
    val phone: InstagramUserNumber = InstagramUserNumber(),
    val type: String = "user",
    var itemClick: Boolean = false,
    var index: Int = 0
): DiffUtilDataInterface, ItemClickInterface {
    override fun keyValue(): String {
        return id
    }

    override fun contentValue(): String {
        return email
    }

    override fun itemType(): String {
        return type
    }

    override fun itemIndex(): String {
        return index.toString()
    }

    override fun setItemIndex(index: Int) {
        this.index = index
    }

    override fun itemClick(): Boolean {
        return itemClick
    }
}

data class InstagramUserNumber(
    val mobile: String = "",
    val home: String = "",
    val office: String = "",
    val type: String = "phone",
    var index: Int = 0
): DiffUtilDataInterface, ItemClickInterface {
    override fun keyValue(): String {
        return mobile
    }

    override fun contentValue(): String {
        return home
    }

    override fun itemType(): String {
        return type
    }

    override fun itemIndex(): String {
        return index.toString()
    }

    override fun setItemIndex(index: Int) {
        this.index = index
    }

    override fun itemClick(): Boolean {
        return false
    }

    fun getMobileNumber(): String {
        return "mobile : $mobile"
    }

    fun getHomeNumber(): String {
        return "home : $home"
    }

    fun getOfficeNumber(): String {
        return "office : $office"
    }
}