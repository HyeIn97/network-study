package com.example.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.proto.model.LikeModel
import com.example.presentation.adapter.LikeAdapter
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentLikeBinding
import com.example.presentation.util.ItemClickListener
import com.example.presentation.viewmodel.LikeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LikeFragment : BaseFragment<FragmentLikeBinding>() {
    private val viewModel: LikeViewModel by viewModels()
    private val likeList = arrayListOf<LikeModel>()
    private val likeAdapter by lazy {
        LikeAdapter(likeList, object : ItemClickListener<LikeModel> {
            override fun itemClick(position: Int, data: LikeModel) {
                super.itemClick(position, data)

                viewModel.deleteLike(position, data)
            }
        })
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentLikeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLike()
        lifecycleScope()
    }

    private fun lifecycleScope() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                launch {
                    viewModel.like.collect {
                        initView(it)
                    }
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.deletePosition.collect {
                        itemRemove(it)
                    }
                }

                launch {
                    viewModel.like.collect {
                        updateLike(it)
                    }
                }
            }
        }
    }

    private fun initView(items: ArrayList<LikeModel>) = with(binding) {
        if (items.isNotEmpty()) {
            likeRecycler.visibility = View.VISIBLE
            emptyTxt.visibility = View.GONE

            if (viewModel.isFirst) {
                viewModel.isFirst = false
                likeList.addAll(items)
                initAdapter()
                viewModel.getLike()
            }
        } else {
            likeRecycler.visibility = View.GONE
            emptyTxt.visibility = View.VISIBLE
        }
    }

    private fun updateLike(items: ArrayList<LikeModel>) {
        val likeSize = likeList.size

        if (likeSize > items.size) {
            likeList.clear()
            likeList.addAll(items)
            likeAdapter.notifyItemChanged(0, items.size)
        } else if (likeSize < items.size) {
            likeList.add(items.get(items.lastIndex))
            likeAdapter.notifyItemChanged(0, items.size)
        }
    }

    private fun initAdapter() = with(binding) {
        likeRecycler.apply {
            itemAnimator = null
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = likeAdapter
        }
    }

    private fun itemRemove(position: Int) = with(binding) {
        likeList.removeAt(position)
        likeAdapter.notifyItemRemoved(position)

        if (likeList.isEmpty()) {
            likeRecycler.visibility = View.GONE
            emptyTxt.visibility = View.VISIBLE
        }
    }
}