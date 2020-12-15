package com.sai.kotlinbase.domainLayer.api

import retrofit2.create

class ApiUtil : Api {
    companion object {
        val REGISTERED_URL: String
            get() = "http://107.180.92.97/api/"
    }

    fun getTailorApi():Api{
        return RetrofitClient.getClient()!!.create(Api::class.java)
    }

    fun getTailorApiWithApiKey(apiKey:String): Api {
        return RetrofitClient.getClientWithApiKey(apiKey)!!.create(Api::class.java)
    }
}