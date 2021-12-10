package com.mahibul.dccdigitalweek.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mahibul.dccdigitalweek.Data.Reposotory.HomePage.User
import com.mahibul.dccdigitalweek.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel = HomeViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //Finding User data

        viewModel.getUserData()
        viewModel.getEventData()

        viewModel.dataUs.observe(viewLifecycleOwner,{
            binding.tvName.text = it.user_name
            binding.tvEmail.text = it.email
            binding.tvBatch.text = "Batch : "+ it.batch
            binding.tvSection.text = "Section : "+it.section
        })

        viewModel.error.observe(viewLifecycleOwner,{
            Toast.makeText(requireContext(),"Data Feach Failed",Toast.LENGTH_LONG).show()
        })
        viewModel.events.observe(viewLifecycleOwner,{
            binding.tvEvent1.text= it.event1
            binding.tvEvent1rank.text=it.event1position
            binding.tvEvent2.text=it.event2
            binding.tvEvent2rank.text=it.event2position
            binding.tvEvent3.text=it.event3
            binding.tvEvent3rank.text=it.event3position
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}