package com.sai.kotlinbase.domainLayer.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient{
    companion object{
        var retrofit: Retrofit? = null

        fun getClient():Retrofit?{
            retrofit = null
            val client = OkHttpClient.Builder()
            client.connectTimeout(25, TimeUnit.SECONDS)
            client.readTimeout(25, TimeUnit.SECONDS)
            client.writeTimeout(25, TimeUnit.SECONDS)


            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(ApiUtil.REGISTERED_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .client(client.build())
                    .build()
            }
            return retrofit
        }

        fun getClientWithApiKey(apiKey:String):Retrofit?{
            retrofit = null

            val client = OkHttpClient.Builder()
            client.connectTimeout(25, TimeUnit.SECONDS)
            client.readTimeout(25, TimeUnit.SECONDS)
            client.writeTimeout(25, TimeUnit.SECONDS)

            client.addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("x-api-key", apiKey)
                    //                        .addHeader("x-access-token",accessToken)
                    .build()
                chain.proceed(request)
            }

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(ApiUtil.REGISTERED_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .client(client.build())
                    .build()
            }
            return retrofit
        }
    }
}