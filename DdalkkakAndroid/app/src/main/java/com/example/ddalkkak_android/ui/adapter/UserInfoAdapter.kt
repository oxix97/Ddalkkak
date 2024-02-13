package com.example.ddalkkak_android.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ddalkkak_android.data.UserInfo
import com.example.ddalkkak_android.databinding.ItemUserInfoBinding
import com.example.ddalkkak_android.util.ListAdapterComparator
import timber.log.Timber

class UserInfoAdapter : ListAdapter<UserInfo, UserInfoAdapter.ViewHolder>(
    ListAdapterComparator<UserInfo>()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserInfoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserInfoAdapter.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }

    inner class ViewHolder(private val binding: ItemUserInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: UserInfo) {
            Timber.d("item : $item")
            binding.data = item
        }
    }
}