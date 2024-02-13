package com.example.ddalkkak_android.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.databinding.ActivityLinkInfoBinding
import com.example.ddalkkak_android.ui.adapter.LinkInfoListAdapter
import com.example.ddalkkak_android.util.BaseViewUtil
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LinkInfoActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityLinkInfoBinding>(R.layout.activity_link_info) {
    private val linkInfoViewModel: LinkInfoViewModel by viewModels()
    private lateinit var linkInfoAdapter: LinkInfoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this@LinkInfoActivity
        initData()
        initView()
    }

    override fun initView() {
        initAdapter()
    }

    private fun initData() {
        val user = intent.getStringExtra("user")
        Timber.d("user : $user")
        linkInfoAdapter = LinkInfoListAdapter()
        linkInfoViewModel.getLinkInfo(user!!)
    }

    private fun initAdapter() {
        linkInfoViewModel.linkInfos.observe(this) {
            linkInfoAdapter.submitList(it)
        }

        with(binding.rvLinkInfoContainer) {
            adapter = linkInfoAdapter
        }
    }
}