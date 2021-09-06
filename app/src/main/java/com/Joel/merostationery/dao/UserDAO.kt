package com.Joel.merostationery.dao

import androidx.room.*
import com.Joel.merostationery.entity.Product

@Dao
interface UserDAO {

    @Insert
    suspend fun registerUser(user: Product)

    @Query( "select * from Product")
    suspend fun checkUser():MutableList<Product>

    @Query("Delete from Product")
    suspend fun delete()
}