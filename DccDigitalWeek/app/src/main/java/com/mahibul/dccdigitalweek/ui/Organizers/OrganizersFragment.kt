package com.mahibul.dccdigitalweek.ui.Organizers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahibul.dccdigitalweek.databinding.FragmentOrganizersBinding

class OrganizersFragment : Fragment() {

    private var _binding: FragmentOrganizersBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOrganizersBinding.inflate(inflater,container,false)
        val root: View = binding.root





        return root
    }


}