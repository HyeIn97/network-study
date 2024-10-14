package com.example.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment() : BaseFragment<FragmentSearchBinding>() {
    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentSearchBinding.inflate(inflater, container, false)
}