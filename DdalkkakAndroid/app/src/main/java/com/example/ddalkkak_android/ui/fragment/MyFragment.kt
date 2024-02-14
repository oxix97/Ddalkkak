package com.example.ddalkkak_android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.databinding.FragmentMyBinding
import com.example.ddalkkak_android.ui.viewmodel.LinkInfoViewModel
import com.example.ddalkkak_android.ui.adapter.LinkInfoListAdapter
import com.example.ddalkkak_android.util.BaseViewUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyFragment : BaseViewUtil.BaseFragment<FragmentMyBinding>(R.layout.fragment_my) {
    private val linkInfoViewModel: LinkInfoViewModel by viewModels()
    private lateinit var linkInfoAdapter: LinkInfoListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }

    override fun initData() {
        linkInfoAdapter = LinkInfoListAdapter()
        linkInfoViewModel.getLikeInfo(16)
    }

    override fun initView() {
        initAdapter()
    }

    private fun initAdapter() {
        linkInfoViewModel.linkInfos.observe(viewLifecycleOwner) {
            linkInfoAdapter.submitList(it)
        }
        with(binding.rvMyContainer) {
            adapter = linkInfoAdapter
        }
    }
}