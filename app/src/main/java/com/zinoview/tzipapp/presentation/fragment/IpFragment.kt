package com.zinoview.tzipapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.zinoview.tzipapp.R
import com.zinoview.tzipapp.databinding.IpFragmentBinding
import com.zinoview.tzipapp.presentation.IpViewModel
import com.zinoview.tzipapp.presentation.IpViewModelFactory
import com.zinoview.tzipapp.presentation.core.BaseFragment
import javax.inject.Inject

class IpFragment : BaseFragment(R.layout.ip_fragment) {

    @Inject
    lateinit var ipViewModelFactory: IpViewModelFactory

    private val ipViewModel: IpViewModel by viewModels {
        ipViewModelFactory
    }

    private var _binding: IpFragmentBinding? = null
    private val binding by lazy {
        checkNotNull(_binding)
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
        _binding = IpFragmentBinding.inflate(layoutInflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        ipViewModel.observe(this) { uiStateScreen ->
            uiStateScreen.handleState(binding.ipPb,binding.ipErrorTv,binding.ipTv)
        }

        binding.ipBtn.setOnClickListener {
            ipViewModel.ip()
        }

    }
}