package com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahibul.protfolioandmvvmarchitecture.R
import com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.adapter.SkillLIstDataAdapter
import com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.model.ListSkillData
import com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.viewmodel.SkillDetaisViewModel
import kotlinx.android.synthetic.main.fragment_skill_details.*

class SkillDetailsFragment : Fragment() {

   lateinit var viewmodel : SkillDetaisViewModel
    private val args : SkillDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skill_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel = ViewModelProvider(this).get(SkillDetaisViewModel::class.java)
        viewmodel.getSkillListDetails()
        viewmodel.userdetailslivedata.observe(viewLifecycleOwner,{
          showOnAdapter(it)
        })
        viewmodel.errorlivedata.observe(viewLifecycleOwner,{
            Toast.makeText(context,it.localizedMessage,Toast.LENGTH_SHORT).show()
        })
    }

    private fun showOnAdapter(it: ListSkillData?) {

        val data = it?.get(args.Listposition)?.skills
        val adapter = data?.let { it1 -> SkillLIstDataAdapter(it1) }

        skill_recyclerviewdetails.layoutManager= LinearLayoutManager(parentFragment?.context,LinearLayoutManager.VERTICAL,false)
        skill_recyclerviewdetails.adapter=adapter
    }
}