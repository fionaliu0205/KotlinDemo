package com.fionaliu.kotlindemo.model

import com.fionaliu.kotlindemo.presenter.LoginPresenter

/**
 * @author FionaLiu(QQ565101845) 2018/5/7 17:32.
 */
interface LoginModel {
    fun login(onLoginListener: LoginPresenter.onLoginListener, name: String, pwd: String)
    fun register(onRegisterListener: LoginPresenter.onRegisterListener, name: String, pwd: String, email: String)
}