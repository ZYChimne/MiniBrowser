package com.zychimne.browser.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoreViewModel:ViewModel() {
    private val mutableAddress = MutableLiveData<String>()
    val address: LiveData<String> get() = mutableAddress

    fun setAddress(address:String) {
        mutableAddress.value=address
    }
}