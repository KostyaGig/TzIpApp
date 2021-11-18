package com.zinoview.tzipapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zinoview.tzipapp.databinding.EmptyItemBinding
import com.zinoview.tzipapp.databinding.ProgressItemBinding
import com.zinoview.tzipapp.databinding.RequestIpItemBinding
import com.zinoview.tzipapp.presentation.state.UiStateScreenIp

interface HistoryRequestsAdapter {

    fun update(newList: List<UiStateScreenIp>)

    class Base : RecyclerView.Adapter<Base.ViewHolder>(), HistoryRequestsAdapter {

        private val ips = ArrayList<UiStateScreenIp>()

        override fun update(newList: List<UiStateScreenIp>) {
            ips.clear()
            ips.addAll(newList)
            notifyDataSetChanged()
        }

        private companion object {
            private const val PROGRESS = 1
            private const val BASE = 2
            private const val EMPTY = 3
        }

        override fun getItemViewType(position: Int): Int {
            return when(ips[position]) {
                is UiStateScreenIp.Progress -> PROGRESS
                is UiStateScreenIp.Cache.Base -> BASE
                else -> EMPTY
            }
        }


        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): Base.ViewHolder {
            return when(viewType) {
                PROGRESS ->
                    ViewHolder.Progress(ProgressItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
                BASE ->
                    ViewHolder.Base(RequestIpItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

                else -> ViewHolder.Empty(EmptyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
        }

        override fun onBindViewHolder(holder: Base.ViewHolder, position: Int) {
            val ip = ips[position]
            holder.bind(ip)
        }

        override fun getItemCount(): Int
            = ips.size

        abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            open fun bind(ip: UiStateScreenIp) {}

            class Progress(view: ProgressItemBinding) : ViewHolder(view.root)

            class Base(view: RequestIpItemBinding) : ViewHolder(view.root) {

                private val ipTextView = view.ipTv
                private val timeRequestTextView = view.timeRequestTv

                override fun bind(ip: UiStateScreenIp) {
                    ip.bind(ipTextView,timeRequestTextView)
                }

            }

            class Empty(view: EmptyItemBinding) : ViewHolder(view.root) {

                private val emptyRequestsTextView = view.emptyRequestsTv

                override fun bind(ip: UiStateScreenIp) {
                    ip.bind(emptyRequestsTextView)
                }
            }
        }
    }
}
