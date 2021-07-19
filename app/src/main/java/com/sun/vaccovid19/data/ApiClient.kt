package com.sun.vaccovid19.data

import com.sun.vaccovid19.BuildConfig
import com.sun.vaccovid19.utils.ApiConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private fun getOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        return builder.addInterceptor {
            val request = it.request().newBuilder()
                .addHeader(ApiConstant.API_PARAM, BuildConfig.API_KEY)
                .build()
            it.proceed(request)

        }.addInterceptor(httpLoggingInterceptor)
            .build()

    }

    fun retrofitBuilder() = Retrofit.Builder()
        .baseUrl(ApiConstant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getOkHttpClient())
        .build()
        .create(ApiService::class.java)
}
