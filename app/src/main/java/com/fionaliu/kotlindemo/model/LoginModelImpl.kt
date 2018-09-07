package com.fionaliu.kotlindemo.model

import com.fionaliu.kotlindemo.presenter.LoginPresenter
import com.fionaliu.kotlindemo.util.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author FionaLiu(QQ565101845) 2018/5/9 16:11.
 */
class LoginModelImpl : LoginModel {
    var mOnLoginListener: LoginPresenter.onLoginListener? = null
    var mOnRegisterListener: LoginPresenter.onRegisterListener? = null
    override fun login(onLoginListener: LoginPresenter.onLoginListener, name: String, pwd: String) {
        mOnLoginListener = onLoginListener
        RetrofitUtils.retrofitService
                .userLogin(name, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    when (result.resCode) {
                        "200" -> mOnLoginListener?.loginSucce(result)
                        else -> mOnLoginListener?.LoginFailed(result.msg)
                    }
                }, { error -> mOnLoginListener?.LoginFailed(error.message) }
                )

    }

    override fun register(onRegisterListener: LoginPresenter.onRegisterListener, name: String, pwd: String, email: String) {
        mOnRegisterListener = onRegisterListener
        RetrofitUtils.retrofitService
                .userRegister(name, pwd, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    when (result.retCode) {
                        "200" -> mOnRegisterListener?.registerSucce(result)
                        else -> mOnRegisterListener?.registerFailed(result.msg)
                    }
                }, { error -> mOnRegisterListener?.registerFailed(error.message) })
    }
}

