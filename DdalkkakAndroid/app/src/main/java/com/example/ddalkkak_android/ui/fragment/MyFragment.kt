package com.example.ddalkkak_android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.data.LinkInfo
import com.example.ddalkkak_android.databinding.FragmentMyBinding
import com.example.ddalkkak_android.ui.adapter.LinkInfoListAdapter
import com.example.ddalkkak_android.ui.viewmodel.LinkInfoViewModel
import com.example.ddalkkak_android.util.BaseViewUtil
import com.example.ddalkkak_android.util.OnItemClickListener
import com.example.ddalkkak_android.util.shortToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyFragment : BaseViewUtil.BaseFragment<FragmentMyBinding>(R.layout.fragment_my) {
    private val linkInfoViewModel: LinkInfoViewModel by activityViewModels()
    private lateinit var linkInfoAdapter: LinkInfoListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }

    override fun initData() {
        linkInfoAdapter = LinkInfoListAdapter(object : OnItemClickListener {
            override fun event(item: LinkInfo) {
                linkInfoViewModel.deleteLinkInfo(item)
                requireActivity().shortToast("찜 삭제 되었습니다.")
            }
        })
    }

    override fun initView() {
        initAdapter()
    }

    private fun initAdapter() {
        linkInfoViewModel.myInfos.observe(viewLifecycleOwner) {
            linkInfoAdapter.submitList(it)
        }
        with(binding.rvMyContainer) {
            adapter = linkInfoAdapter
        }
    }
}