package com.example.ddalkkak_android.ui

import android.os.Bundle
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.databinding.ActivityMainBinding
import com.example.ddalkkak_android.util.BaseViewUtil
import com.example.ddalkkak_android.util.changeFragment
import com.example.ddalkkak_android.util.changeFragmentNoBackStack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityMainBinding>(R.layout.activity_main) {
    private var prevSelectedItem: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBottomNav()
        startFisrtFragment()
        initView()
    }

    override fun initView() {

    }

    private fun startFisrtFragment() {
//        val startFragment = intent.getStringExtra("fragment")
        binding.btNvMain.selectedItemId = R.id.navigation_home
//        when (startFragment) {
//            "mypage" -> binding.btNvMain.selectedItemId = R.id.
//            else -> binding.btNvMain.selectedItemId = R.id.navigation_home
//        }
    }

    private fun initBottomNav() {
        binding.btNvMain.itemIconTintList = null
        binding.btNvMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    prevSelectedItem = 1
                    supportFragmentManager.popBackStack()
                    changeFragmentNoBackStack(R.id.fragment_container_main, HomeFragment())
                    return@setOnItemSelectedListener true
                }

                R.id.navigation_search -> {
                    if (prevSelectedItem == 1) {
                        changeFragment(R.id.fragment_container_main, SearchFragment(), "Search")
                    } else {
                        changeFragmentNoBackStack(R.id.fragment_container_main, SearchFragment())
                    }
                    prevSelectedItem = 2
                    return@setOnItemSelectedListener true
                }

                R.id.navigation_mypage -> {
                    if (prevSelectedItem == 1) {
                        changeFragment(R.id.fragment_container_main, MyFragment(), "MyPage")
                    } else {
                        changeFragmentNoBackStack(R.id.fragment_container_main, MyFragment())
                    }

                    prevSelectedItem = 3
                    return@setOnItemSelectedListener true
                }
            }
            true
        }
    }
}