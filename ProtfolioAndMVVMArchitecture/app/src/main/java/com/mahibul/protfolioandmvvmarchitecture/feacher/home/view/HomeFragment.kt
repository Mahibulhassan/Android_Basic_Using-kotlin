package com.mahibul.protfolioandmvvmarchitecture.feacher.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mahibul.protfolioandmvvmarchitecture.R
import com.mahibul.protfolioandmvvmarchitecture.feacher.home.model.UserDetails
import com.mahibul.protfolioandmvvmarchitecture.feacher.home.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


    lateinit var viewmodel : HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel = ViewModelProvider(this).get(HomeViewModel::class.java)

        progressbarid.visibility = View.VISIBLE
        viewmodel.getUserDetails()
        viewmodel.userdetailslivedata.observe(viewLifecycleOwner,{
            showOnView(it)
        })

        viewmodel.errorlivedata.observe(viewLifecycleOwner,{
           Toast.makeText(context,it.localizedMessage,Toast.LENGTH_SHORT).show()
        })
    }

    private fun showOnView(it: UserDetails?) {
        progressbarid.visibility= View.GONE
        Glide.with(home_iv_img).load(it?.url).into(home_iv_img)
        home_tv_name_value.text= it?.name
        home_tv_description.text=it?.description
    }
}