package com.Joel.merostationery.Repository

import com.Joel.merostationery.*
import com.Joel.merostationery.api.MyApiRequest
import com.Joel.merostationery.api.ServiceBuilder
import com.Joel.merostationery.api.Vegetable
import com.Joel.merostationery.entity.Product
import okhttp3.MultipartBody

class VegRepo: MyApiRequest() {

    var api = ServiceBuilder.buildServices(Vegetable::class.java)

    suspend fun  insertFood(food: Product): ProductResponses {
        return apiRequest {
            api.insertFood(food)
        }
    }
    suspend fun getFood(): ProductResponse {
        return apiRequest {
            api.getFood()
        }
    }
    suspend fun addPhoto(id:String,body: MultipartBody.Part): InsertResponse {
        return apiRequest {

            api.foods(id,body)
        }
    }

    suspend fun addToCart(pid:String,Qty: books): DeleteResponse {

        return apiRequest {
            api.addToCart(pid, ServiceBuilder.token!!,Qty)
        }

    }


    suspend fun getBook(): BookingResponse {
        return apiRequest {
            api.getBooking(ServiceBuilder.token!!)
        }
    }



    suspend fun delete(id:String): DeleteResponse {
        return apiRequest {
            api.deleteBooking(ServiceBuilder.token!!,id)
        }
    }

    suspend fun update(id:String,qty: books): DeleteResponse {
        return apiRequest {
            api.update(ServiceBuilder.token!!,id,qty)
        }
    }






}