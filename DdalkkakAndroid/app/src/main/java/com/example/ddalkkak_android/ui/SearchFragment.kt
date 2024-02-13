package com.example.ddalkkak_android.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.databinding.FragmentSearchBinding
import com.example.ddalkkak_android.ui.adapter.UserInfoAdapter
import com.example.ddalkkak_android.util.BaseViewUtil
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : BaseViewUtil.BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    private val userInfoViewModel: UserInfoViewModel by viewModels()
    private lateinit var userInfoAdapter: UserInfoAdapter
//    private lateinit var linkInfoAdapter: LinkInfoListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userInfoViewModel = userInfoViewModel
        binding.lifecycleOwner = this@SearchFragment
        initData()
        initAdapter()
        initView()
    }

    //    private val linkInfoViewModel: LinkInfoViewModel by viewModels()
    private fun initData() {
        userInfoAdapter = UserInfoAdapter()
        userInfoViewModel.getUsers()
    }

    override fun initView() {
    }

    private fun initAdapter() {
        userInfoViewModel.userInfos.observe(viewLifecycleOwner) {
            Timber.d("옵저버 :$it")
            userInfoAdapter.submitList(it)
        }

        with(binding.rvUserContainer) {
            adapter = userInfoAdapter
        }
    }
}