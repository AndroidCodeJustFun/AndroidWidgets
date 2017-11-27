package com.xiao.demo.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xiao.demo.R
import com.xiao.demo.retrofit.own.LoginRequest
import com.xiao.demo.retrofit.own.OwnHttpAdapterUtil

class KotlinMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        OwnHttpAdapterUtil.load(LoginRequest("", 12));

    }
}
