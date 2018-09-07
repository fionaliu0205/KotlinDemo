package com.fionaliu.kotlindemo.bean

/**
 * 登录返回result
 * token	用户登录生成的token
 * uid	用户Id
 * @author FionaLiu(QQ565101845) 2018/5/7 17:44.
 */
data class LoginResultResponse(val token: String, val uid: String)