package com.mahibul.dccdigitalweek.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mahibul.dccdigitalweek.Data.Reposotory.HomePage.User
import com.mahibul.dccdigitalweek.databinding.FragmentHomeBinding

class HomeFragment : Fragment(),FindData{

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel = HomeViewModel(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //Finding User data

        viewModel.getUserData()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun findData(data: User) {
        binding.tvName.text = data.user_name
        binding.tvEmail.text = data.email
        binding.tvBatch.text = "Batch : "+ data.batch
        binding.tvSection.text = "Section : "+data.section
    }

    override fun error(error: String) {
        Toast.makeText(requireContext(),"Data Featch Failed",Toast.LENGTH_LONG).show()
    }


}