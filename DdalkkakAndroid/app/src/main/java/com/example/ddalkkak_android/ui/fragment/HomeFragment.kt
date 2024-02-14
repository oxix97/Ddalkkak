package com.example.ddalkkak_android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.databinding.FragmentHomeBinding
import com.example.ddalkkak_android.ui.viewmodel.LinkInfoViewModel
import com.example.ddalkkak_android.ui.adapter.LinkInfoListAdapter
import com.example.ddalkkak_android.util.BaseViewUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseViewUtil.BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val linkInfoViewModel: LinkInfoViewModel by viewModels()
    private lateinit var linkInfoAdapter: LinkInfoListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.linkInfoViewModel = linkInfoViewModel
        binding.lifecycleOwner = this@HomeFragment
        initData()
        initView()
    }


    override fun initData() {
        linkInfoAdapter = LinkInfoListAdapter()
        linkInfoViewModel.getLinkInfos()
    }

    override fun initView() {
        initAdapter()
    }

    private fun initAdapter() {
        linkInfoViewModel.linkInfos.observe(viewLifecycleOwner) {
            linkInfoAdapter.submitList(it)
        }
        with(binding.rvMainContainer) {
            adapter = linkInfoAdapter
        }
    }
}