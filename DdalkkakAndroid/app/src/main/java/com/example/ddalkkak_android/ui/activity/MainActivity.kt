package com.example.ddalkkak_android.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.databinding.ActivityMainBinding
import com.example.ddalkkak_android.ui.fragment.HomeFragment
import com.example.ddalkkak_android.ui.fragment.MyFragment
import com.example.ddalkkak_android.ui.fragment.SearchFragment
import com.example.ddalkkak_android.ui.fragment.UsersFragment
import com.example.ddalkkak_android.ui.viewmodel.LinkInfoViewModel
import com.example.ddalkkak_android.ui.viewmodel.UserInfoViewModel
import com.example.ddalkkak_android.util.BaseViewUtil
import com.example.ddalkkak_android.util.changeFragment
import com.example.ddalkkak_android.util.changeFragmentNoBackStack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityMainBinding>(R.layout.activity_main) {
    private var prevSelectedItem: Int = 1
    private val linkInfoViewModel: LinkInfoViewModel by viewModels()
    private val userInfoViewModel: UserInfoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        initBottomNav()
        startFisrtFragment()
        initView()
        initData()
    }

    private fun initData() {
        linkInfoViewModel.getAll()
        linkInfoViewModel.getLinkInfos()
        userInfoViewModel.getUsers()
    }

    override fun initView() {

    }

    private fun startFisrtFragment() {
        binding.btNvMain.selectedItemId = R.id.navigation_home
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

                R.id.navigation_user -> {
                    if (prevSelectedItem == 1) {
                        changeFragment(R.id.fragment_container_main, UsersFragment(), "Users")
                    } else {
                        changeFragmentNoBackStack(R.id.fragment_container_main, UsersFragment())
                    }
                    prevSelectedItem = 2
                    return@setOnItemSelectedListener true
                }

                R.id.navigation_search -> {
                    if (prevSelectedItem == 1) {
                        changeFragment(R.id.fragment_container_main, SearchFragment(), "Search")
                    } else {
                        changeFragmentNoBackStack(R.id.fragment_container_main, SearchFragment())
                    }
                    prevSelectedItem = 3
                    return@setOnItemSelectedListener true
                }

                R.id.navigation_star -> {
                    if (prevSelectedItem == 1) {
                        changeFragment(R.id.fragment_container_main, MyFragment(), "MyPage")
                    } else {
                        changeFragmentNoBackStack(R.id.fragment_container_main, MyFragment())
                    }

                    prevSelectedItem = 4
                    return@setOnItemSelectedListener true
                }
            }
            true
        }
    }
}