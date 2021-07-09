package com.example.vaccovid19.data

import com.example.vaccovid19.BuildConfig
import com.example.vaccovid19.utils.ApiConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        return builder.addInterceptor {
            val original = it.request()
            val url = original.url.newBuilder()
                .addQueryParameter(ApiConstant.API_PARAM, BuildConfig.API_KEY)
                .build()
            val request = original.newBuilder().url(url).build()
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
