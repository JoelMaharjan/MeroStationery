package com.Joel.merostationery

import com.Joel.merostationery.entity.Product
import com.Joel.merostationery.entity.User


data class Booking(
    val _id:String?=null,
    val User: User?=null,
    val Qty:Int?=null,
    val Vegetables: Product?=null,
    val Date:String?=null


)