package com.mahibul.dccdigitalweek.ui.Schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mahibul.dccdigitalweek.Data.Reposotory.Schedule.ScheduleTime
import com.mahibul.dccdigitalweek.databinding.FragmentSchduleBinding


class SchduleFragment : Fragment() {

    private val viewModel = SchduleViewModel()

    private var _binding: FragmentSchduleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSchduleBinding.inflate(inflater, container, false)
        val root: View = binding.root


        viewModel.getSchdule()
        viewModel.getdata.observe(viewLifecycleOwner,{
            binding.tvBanertime.text = it.banner
            binding.tvIdeasub.text = it.ideasub
            binding.tvMock.text =it.mock
            binding.tvProOlym.text = it.proolym
            binding.tvWebsite.text = it.website
            binding.tvProgcontest.text= it.programming
            binding.tvPricegiven.text =  it.pricegiven
        })
        viewModel.error.observe(viewLifecycleOwner,{
            Toast.makeText(requireContext(),"Schdule Emty",Toast.LENGTH_SHORT).show()
        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}