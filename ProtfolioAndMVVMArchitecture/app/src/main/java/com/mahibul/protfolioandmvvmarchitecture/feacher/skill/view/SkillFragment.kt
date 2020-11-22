package com.mahibul.protfolioandmvvmarchitecture.feacher.skill.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahibul.protfolioandmvvmarchitecture.R
import com.mahibul.protfolioandmvvmarchitecture.feacher.skill.Adapter.ClickListner
import com.mahibul.protfolioandmvvmarchitecture.feacher.skill.Adapter.SkillLIstAdapter
import com.mahibul.protfolioandmvvmarchitecture.feacher.skill.model.SkillData
import com.mahibul.protfolioandmvvmarchitecture.feacher.skill.viewmodel.SkillViewModel
import kotlinx.android.synthetic.main.fragment_skill.*

class SkillFragment : Fragment() {
    lateinit var viewmodel : SkillViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = ViewModelProvider(this).get(SkillViewModel::class.java)
        viewmodel.getSkillsDetais()

        viewmodel.userdetailslivedata.observe(viewLifecycleOwner,{
            showOnView(it)
        })
    }

    private fun showOnView(it: SkillData?) {

        val adapter = it?.let { it1 -> SkillLIstAdapter(it1,object : ClickListner {
            override fun returnPosition(position: Int) {
                val derection = SkillFragmentDirections.actionNavSkillToNavSkilldetais(position)
                findNavController().navigate(derection)
            }
        }) }
        skill_recyclerview.layoutManager = LinearLayoutManager(parentFragment?.context, LinearLayoutManager.VERTICAL,false)
        skill_recyclerview.adapter=adapter
    }

}