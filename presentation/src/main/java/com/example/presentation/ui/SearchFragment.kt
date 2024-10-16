package com.example.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentSearchBinding
import com.example.presentation.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment() : BaseFragment<FragmentSearchBinding>() {
    private val viewModel: SearchViewModel by viewModels()
    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentSearchBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifeCycleScope()
        listener()
        initAdapter()
    }

    private fun lifeCycleScope() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            launch {
                viewModel.search.collect {
                    it?.let {
                        Log.d("debug", "결과 값  : $it")
                    }
                }
            }
        }
    }

    private fun listener() = with(binding) {
        searchButton.setOnClickListener {
            val query = searchEdit.toString()
            Log.d("debug", "검색어 : $query")
            viewModel.getSearch(query, 1, 10)
        }
    }

    private fun initAdapter() = with(binding) {

    }
}