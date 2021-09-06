package com.Joel.merostationery

import com.Joel.merostationery.entity.User

data class InsertResponse(
    val status:Boolean?=null,
    val data: User?=null

) {
}