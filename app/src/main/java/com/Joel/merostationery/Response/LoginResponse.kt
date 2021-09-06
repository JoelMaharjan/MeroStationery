package com.example.Online_Stationary.Response

import com.Joel.merostationery.entity.User

data class LoginResponse(
    val success:Boolean?=null,
    val token:String?=null,
    val data: User?=null
)
