package com.example.presentation.ui.activity

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.presentation.databinding.ActivityDetailBinding
import com.example.presentation.model.DetailLikeModel
import com.example.presentation.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(binding.root)

        viewModel.like = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("data", DetailLikeModel::class.java)
        } else {
            intent.getParcelableExtra("data")
        }

        viewModel.isLike()

        initView()
        listener()
        lifeCycleScope()
    }

    private fun lifeCycleScope() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            launch {
                viewModel.isLIke.collect {
                    binding.likeBtn.isChecked = it
                }
            }
        }
    }

    private fun initView() = with(binding) {
        detailImage.setUrl(viewModel.like?.image ?: "")
        detailTitle.text = viewModel.like?.title ?: ""
    }

    private fun listener() = with(binding) {
        backBtn.setOnClickListener {
            finish()
        }

        likeBtn.setOnClickListener {
            if (likeBtn.isChecked) viewModel.setLike() else viewModel.deleteLike()
        }
    }
}