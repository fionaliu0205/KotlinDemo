package com.fionaliu.kotlindemo.presenter

import com.fionaliu.kotlindemo.bean.LoginResponse
import com.fionaliu.kotlindemo.bean.RegisterResponse

/**
 * @author FionaLiu(QQ565101845) 2018/5/7 17:33.
 */
interface LoginPresenter {
    fun login(name: String, pwd: String)
    interface onLoginListener {
        fun loginSucce(result: LoginResponse)
        fun LoginFailed(msg: String?)
    }

    fun register(name: String, pwd: String, email: String)
    interface onRegisterListener {
        fun registerSucce(result: RegisterResponse)
        fun registerFailed(msg: String?)
    }
}