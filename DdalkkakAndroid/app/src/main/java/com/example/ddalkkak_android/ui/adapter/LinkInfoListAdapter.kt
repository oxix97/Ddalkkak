package com.example.ddalkkak_android.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ddalkkak_android.data.LinkInfo
import com.example.ddalkkak_android.databinding.ItemLinkInfoBinding
import com.example.ddalkkak_android.util.ListAdapterComparator

class LinkInfoListAdapter : ListAdapter<LinkInfo, LinkInfoListAdapter.ViewHolder>(
    ListAdapterComparator<LinkInfo>()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLinkInfoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }

    inner class ViewHolder(private val binding: ItemLinkInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: LinkInfo) {
            with(binding) {
                data = item
            }
        }
    }
}