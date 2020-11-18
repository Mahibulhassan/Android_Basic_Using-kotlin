package com.mahibul.navigation_drawerfragmentactivity.feacher.aboutApp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahibul.navigation_drawerfragmentactivity.R
import kotlinx.android.synthetic.main.fragment_about_app_fragment.*


class about_app_fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about_app_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_about_fragemnt.text="This app is use for test about fragment"
    }

}