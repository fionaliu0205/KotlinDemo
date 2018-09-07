package com.fionaliu.kotlindemo.api

import com.fionaliu.kotlindemo.bean.LoginResponse
import com.fionaliu.kotlindemo.bean.RegisterResponse
import com.fionaliu.kotlindemo.constant.Constant
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author FionaLiu(QQ565101845) 2018/5/7 17:47.
 */
interface RetrofitService {
    @GET("rigister")
    fun userRegister(
            @Query("username") name: String,
            @Query("password") pwd: String,
            @Query("email") email: String,
            @Query("key") key: String = Constant.KEY
    ): Observable<RegisterResponse>


    @GET("login")
    fun userLogin(
            @Query("username") name: String,
            @Query("password") pwd: String,
            @Query("key") key: String = Constant.KEY
    ): Observable<LoginResponse>
}