package com.example.instagramapi.data.model

import com.example.instagramapi.common.diffUtil.DiffUtilDataInterface

data class InstagramModel(
    var contacts: List<InstagramUser> = mutableListOf()
)

data class InstagramUser(
    var id: String = "",
    var name: String = "",
    var email: String = "",
    var address: String = "",
    var gender: String = "",
    var phone: InstagramUserNumber = InstagramUserNumber()
): DiffUtilDataInterface {
    override fun keyValue(): String {
        return id
    }

    override fun contentValue(): String {
        return email
    }
}

data class InstagramUserNumber(
    var mobile: String = "",
    var home: String = "",
    var office: String = ""
)