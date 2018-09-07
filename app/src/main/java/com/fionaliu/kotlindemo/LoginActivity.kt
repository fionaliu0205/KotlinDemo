package com.fionaliu.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Button
import cn.pedant.SweetAlert.SweetAlertDialog
import com.fionaliu.kotlindemo.bean.LoginResponse
import com.fionaliu.kotlindemo.bean.RegisterResponse
import com.fionaliu.kotlindemo.presenter.LoginPresenter
import com.fionaliu.kotlindemo.presenter.LoginPresenterImpl
import com.fionaliu.kotlindemo.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity(), View.OnClickListener, LoginView {
    var loginPresenter: LoginPresenter? = null;
    var dialog: SweetAlertDialog? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginPresenterImpl(this)
        login.setOnClickListener(this)
        register.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.login -> {
                if ()

            }
            R.id.register -> {

            }
        }
    }

    private fun checkContent(login: Boolean): Boolean {
        username.error = null
        password.error = null
        email.error = null

        var cancel = false
        var focusView: View? = null

        if (!login) {

            if (TextUtils.isEmpty(email.text.toString())){
                email.error=R.string.login_login
            }
        }
    }

    override fun loginSuccess(result: LoginResponse) {
    }

    override fun loginFailed(message: String?) {
    }

    override fun registerSuccess(result: RegisterResponse) {
    }

    override fun registerFailed(message: String?) {
    }

}