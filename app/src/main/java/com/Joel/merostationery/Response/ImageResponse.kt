package com.example.Online_Stationary.Response

import com.Joel.merostationery.entity.User

data class ImageResponse(
    val success:Boolean?=null,
    val data: User?=null,
    val message:String?=null

) {
}