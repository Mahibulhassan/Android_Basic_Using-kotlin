package com.mahibul.dccdigitalweek.ui.Registration

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.mahibul.dccdigitalweek.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegistrationBinding.inflate(inflater,container,false)
        val root: View = binding.root
// WebView work here
        binding!!.WebView.webViewClient = WebViewClient()
        binding!!.WebView.loadUrl("https://docs.google.com/forms/d/101uGRBM_oiwx4sipTbp6We5lmqO4HVJxME9sOv1FOAg/viewform?edit_requested=true")
        val websettings = binding!!.WebView.settings
        websettings.javaScriptEnabled = true

        binding.WebView.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
                if (p2!!.action == KeyEvent.ACTION_DOWN){
                    if (p1==KeyEvent.KEYCODE_BACK){
                        if (binding!!.WebView != null){
                                if (binding!!.WebView.canGoBack()){
                                    binding!!.WebView.goBack()
                                }else{
                                    activity?.onBackPressed()
                                }
                        }
                    }
                }
                return true
            }

        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}