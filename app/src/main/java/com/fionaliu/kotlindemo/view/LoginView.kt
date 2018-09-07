package com.fionaliu.kotlindemo.view

import com.fionaliu.kotlindemo.bean.LoginResponse
import com.fionaliu.kotlindemo.bean.RegisterResponse

/**
 * @author FionaLiu(QQ565101845) 2018/5/15 10:52.
 */
interface LoginView {
    fun loginSuccess(result: LoginResponse)
    fun loginFailed(message: String?)
    fun registerSuccess(result: RegisterResponse)
    fun registerFailed(message: String?)
}