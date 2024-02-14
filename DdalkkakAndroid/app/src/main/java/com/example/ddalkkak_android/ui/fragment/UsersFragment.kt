package com.example.ddalkkak_android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.databinding.FragmentUsersBinding
import com.example.ddalkkak_android.ui.adapter.UserInfoAdapter
import com.example.ddalkkak_android.ui.viewmodel.UserInfoViewModel
import com.example.ddalkkak_android.util.BaseViewUtil
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class UsersFragment : BaseViewUtil.BaseFragment<FragmentUsersBinding>(R.layout.fragment_users) {
    private val userInfoViewModel: UserInfoViewModel by viewModels()
    private lateinit var userInfoAdapter: UserInfoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userInfoViewModel = userInfoViewModel
        binding.lifecycleOwner = this@UsersFragment
        initData()
        initAdapter()
        initView()
    }

    override fun initData() {
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
            this.layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = userInfoAdapter
        }
    }

}