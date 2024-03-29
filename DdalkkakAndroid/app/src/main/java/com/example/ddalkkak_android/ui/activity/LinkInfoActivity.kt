package com.example.ddalkkak_android.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.data.LinkInfo
import com.example.ddalkkak_android.databinding.ActivityLinkInfoBinding
import com.example.ddalkkak_android.ui.viewmodel.LinkInfoViewModel
import com.example.ddalkkak_android.ui.adapter.LinkInfoListAdapter
import com.example.ddalkkak_android.util.BaseViewUtil
import com.example.ddalkkak_android.util.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LinkInfoActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityLinkInfoBinding>(R.layout.activity_link_info) {
    private val linkInfoViewModel: LinkInfoViewModel by viewModels()
    private lateinit var linkInfoAdapter: LinkInfoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        initData()
        initView()
    }

    override fun initView() {
        initAdapter()
    }

    private fun initData() {
        val user = intent.getStringExtra("user")
        Timber.d("user : $user")
        linkInfoAdapter = LinkInfoListAdapter(object : OnItemClickListener {
            override fun event(item: LinkInfo) {
                linkInfoViewModel.insertLinkInfo(item)
            }
        })
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