package com.example.presentation.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.R
import com.example.presentation.adapter.ViewPagerAdapter
import com.example.presentation.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var backPressTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.onBackPressedDispatcher.addCallback(this, callback)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(binding.root)

        initAdapter()
    }

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (System.currentTimeMillis() - backPressTime <= 2000) {
                finish()
            } else {
                backPressTime = System.currentTimeMillis()
                Toast.makeText(this@MainActivity, getString(R.string.app_finish), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initAdapter() = with(binding) {
        viewPager.run {
            isUserInputEnabled = false
            adapter = ViewPagerAdapter(this@MainActivity)
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.search_tab)
                else -> tab.text = getString(R.string.like_tab)
            }
        }.attach()
    }
}