package com.fionaliu.kotlindemo.util

import android.util.Log
import com.fionaliu.kotlindemo.api.RetrofitService
import com.fionaliu.kotlindemo.constant.Constant
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * @author FionaLiu(QQ565101845) 2018/5/9 16:23.
 */
class RetrofitUtils<T> {
    companion object {
        fun create(url: String): Retrofit {
            val level: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
            val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                Log.d("RetrofitUtils", "OkHttp:" + message)
            })
            loggingInterceptor.level = level
            val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient().newBuilder()
            okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(10, TimeUnit.SECONDS)
            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }

        val retrofitService: RetrofitService = RetrofitUtils.getService(Constant.REQUEST_BASE_URL, RetrofitService::class.java)
        fun <T> getService(url: String, service: Class<T>): T {
            return create(url).create(service)
        }
    }
}