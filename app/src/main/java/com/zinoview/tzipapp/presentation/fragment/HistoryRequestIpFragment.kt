package com.zinoview.tzipapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.zinoview.tzipapp.R
import com.zinoview.tzipapp.databinding.HistoryRequestIpFragmentBinding
import com.zinoview.tzipapp.presentation.IpViewModel
import com.zinoview.tzipapp.presentation.IpViewModelFactory
import com.zinoview.tzipapp.presentation.adapter.HistoryRequestsAdapter
import com.zinoview.tzipapp.presentation.core.BaseFragment
import javax.inject.Inject

class HistoryRequestIpFragment : BaseFragment(R.layout.history_request_ip_fragment) {

    private var _binding: HistoryRequestIpFragmentBinding? = null
    private val binding by lazy {
        checkNotNull(_binding)
    }

    @Inject
    lateinit var ipViewModelFactory: IpViewModelFactory

    private val ipViewModel:IpViewModel by viewModels {
        ipViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HistoryRequestIpFragmentBinding.inflate(layoutInflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = HistoryRequestsAdapter.Base()
        binding.historyRequestsIpRecView.adapter = adapter

        ipViewModel.observe(this) { uiStateScreenIp ->
            adapter.update(uiStateScreenIp)
        }

        ipViewModel.historyRequestsIp()

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_historyRequestIpFragment_to_ipFragment)
            }
        })
    }

}