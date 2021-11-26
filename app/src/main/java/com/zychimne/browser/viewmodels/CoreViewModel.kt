package com.zychimne.browser.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoRuntimeSettings
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoSessionSettings

class CoreViewModel:ViewModel() {
    private val mutableAddress = MutableLiveData<String>()
    val address: LiveData<String> get() = mutableAddress

    fun openSession(context: Context): GeckoSession{
        val session = GeckoSession()
        session.settings.userAgentMode= GeckoSessionSettings.USER_AGENT_MODE_DESKTOP
        val runtime = context?.let { GeckoRuntime.getDefault(it) }
        if (runtime != null) {
            session.open(runtime)
        }
        return session
    }
    fun setAddress(address:String) {
        mutableAddress.value=address
    }
}