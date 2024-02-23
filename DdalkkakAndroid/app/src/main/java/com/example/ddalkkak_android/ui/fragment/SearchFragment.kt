package com.example.ddalkkak_android.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.data.LinkInfo
import com.example.ddalkkak_android.databinding.FragmentSearchBinding
import com.example.ddalkkak_android.ui.adapter.LinkInfoListAdapter
import com.example.ddalkkak_android.ui.viewmodel.UserInfoViewModel
import com.example.ddalkkak_android.ui.adapter.UserInfoAdapter
import com.example.ddalkkak_android.ui.viewmodel.LinkInfoViewModel
import com.example.ddalkkak_android.util.BaseViewUtil
import com.example.ddalkkak_android.util.OnItemClickListener
import com.example.ddalkkak_android.util.shortToast
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : BaseViewUtil.BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    private val linkInfoViewModel: LinkInfoViewModel by activityViewModels()
    private lateinit var linkInfoAdapter: LinkInfoListAdapter
    private lateinit var searchingWord: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }

    override fun initData() {
        linkInfoAdapter = LinkInfoListAdapter(object : OnItemClickListener {
            override fun event(item: LinkInfo) {
                linkInfoViewModel.insertLinkInfo(item)
                requireActivity().shortToast("찜 추가 되었습니다.")
            }
        })
    }

    override fun initView() {
        initAdapter()
        binding.etSearch.setOnEditorActionListener { textView, action, event ->
            var handled = false
            if (action == EditorInfo.IME_ACTION_DONE) {
                linkInfoViewModel.getSearchLinkInfo(textView.text.toString())
                handled = true
            }
            handled
        }
    }

    private fun searching() {
        searchingWord = binding.etSearch.text.toString()
    }

    private fun initAdapter() {
        linkInfoViewModel.searchInfos.observe(viewLifecycleOwner) {
            linkInfoAdapter.submitList(it)
        }
        with(binding.rvSearchContainer) {
            adapter = linkInfoAdapter
        }
    }
}