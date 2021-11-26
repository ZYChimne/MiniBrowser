package com.zychimne.browser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.zychimne.browser.databinding.FragmentCoreBinding
import com.zychimne.browser.viewmodels.CoreViewModel
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoSessionSettings
import org.mozilla.geckoview.GeckoView


class CoreFragment : Fragment() {

    private var _binding: FragmentCoreBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewmodel:CoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoreBinding.inflate(inflater, container, false)
        val view: GeckoView = binding.geckoview
        val session = context?.let { viewmodel.openSession(it) }
        viewmodel.address.value?.let {
            if (session != null) {
                view.setSession(session)
                session.loadUri(it) // Or any other URL...
            }
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}