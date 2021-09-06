package com.Joel.merostationery.Repository


import com.Joel.merostationery.api.MyApiRequest
import com.Joel.merostationery.api.ServiceBuilder
import com.Joel.merostationery.entity.Register
import com.Joel.merostationery.InsertResponse
import com.example.Online_Stationary.Response.ImageResponse
import com.example.Online_Stationary.Response.LoginResponse
import okhttp3.MultipartBody

class UserRepo: MyApiRequest() {

    val api = ServiceBuilder.buildServices(com.Joel.merostationery.api.api::class.java)


    suspend fun Login(username:String, password:String): LoginResponse {
        return apiRequest {

            api.Login(username, password)
        }

    }



    suspend fun register(user: Register): InsertResponse
    {
        return apiRequest {
            api.Register(user)
        }

    }

    suspend fun upload( id:String,body: MultipartBody.Part): ImageResponse {
        return apiRequest {
            api.addPhoto(id,body)
        }
    }



}
