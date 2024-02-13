package com.example.ddalkkak_android.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.databinding.ActivitySplashBinding
import com.example.ddalkkak_android.util.BaseViewUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
