package com.zychimne.browser

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.zychimne.browser.databinding.ActivityMainBinding
import com.zychimne.browser.viewmodels.CoreViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val coreViewModel:CoreViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        coreViewModel.setAddress("www.apple.com.cn/iphone")
        coreViewModel.address.observe(this, Observer { address->
            binding.searchbar.setText(address)
        })
    }
}