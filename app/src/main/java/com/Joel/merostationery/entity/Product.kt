package com.Joel.merostationery.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Product(


    @PrimaryKey
    var _id: String="",
    var Name:String?=null,
    var Description:String?=null,
    var Price:String?=null,
    var Image:String?=null



)