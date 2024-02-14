package com.example.ddalkkak_android.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

sealed class BaseViewUtil {
    abstract class BaseAppCompatActivity<T : ViewDataBinding>(private val layoutResId: Int) :
        AppCompatActivity() {
        protected lateinit var binding: T
        private lateinit var imm: InputMethodManager

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = DataBindingUtil.setContentView(this, layoutResId)
            binding.lifecycleOwner = this

            imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        }

        abstract fun initView()
    }

    abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes val layout: Int) : Fragment() {
        private var _binding: T? = null
        protected val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = DataBindingUtil.inflate(inflater, layout, container, false)
            binding.lifecycleOwner = viewLifecycleOwner
            return binding.root
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

        abstract fun initView()
        abstract fun initData()
    }

    abstract class BaseBottomDialogFragment<T : ViewDataBinding>(@LayoutRes val layout: Int) :
        BottomSheetDialogFragment() {
        private var _binding: T? = null
        protected val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = DataBindingUtil.inflate(inflater, layout, container, false)
            binding.lifecycleOwner = viewLifecycleOwner
            return binding.root
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

        abstract fun initView()
    }
}