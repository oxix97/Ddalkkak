package com.example.ddalkkak_android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.databinding.FragmentSearchBinding
import com.example.ddalkkak_android.ui.viewmodel.UserInfoViewModel
import com.example.ddalkkak_android.ui.adapter.UserInfoAdapter
import com.example.ddalkkak_android.util.BaseViewUtil
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : BaseViewUtil.BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }

    override fun initView() {

    }

    override fun initData() {

    }
}