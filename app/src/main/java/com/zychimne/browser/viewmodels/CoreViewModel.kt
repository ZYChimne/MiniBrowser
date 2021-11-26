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
    private val mutableSession = MutableLiveData<GeckoSession>()
    val session: LiveData<GeckoSession> get() = mutableSession

    fun openSession(context: Context) {
        mutableSession.value=GeckoSession()
        session.value?.settings?.userAgentMode = GeckoSessionSettings.USER_AGENT_MODE_DESKTOP
        val runtime = context?.let { GeckoRuntime.getDefault(it) }
        if (runtime != null) {
            session.value?.open(runtime)
            address.value?.let {
                session.value?.loadUri(it)
            }
        }
    }
    fun setAddress(address:String) {
        mutableAddress.value=address
    }
    fun refresh(){
        address.value?.let { session.value?.loadUri(it) }
    }
}