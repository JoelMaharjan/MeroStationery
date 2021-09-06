package com.Joel.merostationery

import com.Joel.merostationery.entity.Product

data class ProductResponse (
    val success:Boolean?=null,
    val data:MutableList<Product>?=null

        ){
}