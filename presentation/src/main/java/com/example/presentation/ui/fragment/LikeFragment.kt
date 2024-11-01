package com.example.presentation.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentLikeBinding
import com.example.presentation.viewmodel.LikeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeFragment : BaseFragment<FragmentLikeBinding>() {
    private val viewModel: LikeViewModel by viewModels()
    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentLikeBinding.inflate(inflater, container, false)
}