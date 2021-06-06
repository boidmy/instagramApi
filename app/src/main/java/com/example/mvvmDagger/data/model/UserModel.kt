package com.example.mvvmDagger.data.model

import com.example.mvvmDagger.common.Interface.ItemClickInterface
import com.example.mvvmDagger.common.diffUtil.DiffUtilDataInterface

data class UserModel(
    val contacts: List<User> = mutableListOf()
) {
    fun setItemIndex() {
        for ((index, item) in contacts.withIndex()) {
            item.index = index
        }
    }
}

data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val address: String = "",
    val gender: String = "",
    val phone: UserNumber = UserNumber(),
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

data class UserNumber(
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