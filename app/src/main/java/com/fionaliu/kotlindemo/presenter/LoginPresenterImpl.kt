package com.fionaliu.kotlindemo.presenter

import com.fionaliu.kotlindemo.bean.LoginResponse
import com.fionaliu.kotlindemo.bean.RegisterResponse
import com.fionaliu.kotlindemo.model.LoginModel
import com.fionaliu.kotlindemo.model.LoginModelImpl
import com.fionaliu.kotlindemo.view.LoginView

/**
 * @author FionaLiu(QQ565101845) 2018/5/15 10:56.
 */
class LoginPresenterImpl(val loginView: LoginView) : LoginPresenter, LoginPresenter.onLoginListener, LoginPresenter.onRegisterListener {
    val mLoginModel: LoginModel

    init {
        mLoginModel = LoginModelImpl()
    }

    override fun login(name: String, pwd: String) {
        mLoginModel.login(this, name, pwd)
    }

    override fun loginSucce(result: LoginResponse) {
        loginView.loginSuccess(result)
    }

    override fun LoginFailed(msg: String?) {
        loginView.loginFailed(msg)
    }

    override fun register(name: String, pwd: String, email: String) {
        mLoginModel.register(this, name, pwd, email)
    }

    override fun registerSucce(result: RegisterResponse) {
        loginView.registerSuccess(result)
    }

    override fun registerFailed(msg: String?) {
        loginView.registerFailed(msg)
    }
}