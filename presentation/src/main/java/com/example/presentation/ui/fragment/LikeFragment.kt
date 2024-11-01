package com.example.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.proto.model.LikeModel
import com.example.presentation.adapter.LikeAdapter
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentLikeBinding
import com.example.presentation.viewmodel.LikeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LikeFragment : BaseFragment<FragmentLikeBinding>() {
    private val viewModel: LikeViewModel by viewModels()
    private val likeList = arrayListOf<LikeModel>()
    private val likeAdapter by lazy {
        LikeAdapter(likeList)
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentLikeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLike()
        lifeCycleScope()
    }

    private fun lifeCycleScope() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            launch {
                viewModel.like.collect {
                    if (it.size > 0) {
                        binding.likeRecycler.visibility = View.VISIBLE
                        binding.emptyTxt.visibility = View.GONE

                        hasLike()
                    } else {
                        binding.likeRecycler.visibility = View.GONE
                        binding.emptyTxt.visibility = View.VISIBLE

                        notLike()
                    }
                }
            }
        }
    }

    private fun hasLike() {
        initAdapter()
    }

    private fun notLike() {

    }

    private fun initAdapter() = with(binding) {
        likeRecycler.apply {
            itemAnimator = null
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = likeAdapter
        }
    }
}