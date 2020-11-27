package com.mahibul.protfolioandmvvmarchitecture.feacher.contruct.view

import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.mahibul.protfolioandmvvmarchitecture.R
import kotlinx.android.synthetic.main.fragment_contruct.*
import java.util.jar.Manifest

class ContructFragment : Fragment() {

    val REQUEST_PHONE_CALL = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contruct, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contuct_btn_call.setOnClickListener{
            if(this.activity?.let { it1 -> ActivityCompat.checkSelfPermission(it1,android.Manifest.permission.CALL_PHONE) } != PackageManager.PERMISSION_GRANTED){
                this.activity?.let { it1 -> ActivityCompat.requestPermissions(it1, arrayOf(android.Manifest.permission.CALL_PHONE),REQUEST_PHONE_CALL) }
            }else{
                startcall()
            }
        }
    }

    private fun startcall()
    {
        val intent = Intent(Intent.ACTION_CALL)
        val phonenumber = "01681690327"
        intent.setData(Uri.parse("tel:" + phonenumber))
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == REQUEST_PHONE_CALL)
            startcall()
    }


}