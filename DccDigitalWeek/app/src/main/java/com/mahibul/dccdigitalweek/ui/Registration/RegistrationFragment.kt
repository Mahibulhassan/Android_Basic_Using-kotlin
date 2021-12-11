package com.mahibul.dccdigitalweek.ui.Registration

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mahibul.dccdigitalweek.Data.Reposotory.Registration.EventData
import com.mahibul.dccdigitalweek.databinding.FragmentRegistrationBinding
import com.mahibul.dccdigitalweek.ui.Registration.ViewModel.EventsViewMOdel

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    private val viewModel = EventsViewMOdel()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegistrationBinding.inflate(inflater,container,false)
        val root: View = binding.root

        binding.btnSubmit.setOnClickListener {
            val events = mutableListOf<String>()
            events.clear()
            if (binding.cheackprogramming.isChecked){
                events.add(binding.cheackprogramming.text.toString())
            }
            if (binding.cheackbanner.isChecked){
                events.add(binding.cheackbanner.text.toString())
            }
            if (binding.cheackwebdegin.isChecked){
                events.add(binding.cheackwebdegin.text.toString())
            }
            if (binding.cheackideasub.isChecked){
                events.add(binding.cheackideasub.text.toString())
            }

            if (binding.cheackolymp.isChecked){
                events.add(binding.cheackolymp.text.toString())
            }
            if (binding.cheackposter.isChecked){
                events.add(binding.cheackposter.text.toString())
            }

            if(events.size<=0){
                Toast.makeText(requireContext(),"Chose Your Events",Toast.LENGTH_LONG).show()
            }else{
                if (events.size > 3){
                    Toast.makeText(requireContext(),"You can Participate Maximum 3",Toast.LENGTH_LONG).show()
                }else if(events.size == 1){
                    val data = EventData(events[0],"Event : Null","Event : Null","Position : Null","Position : Null","Position : Null")
                    viewModel.updateEvents(data)

                }else if(events.size == 2){

                    val data = EventData(events[0],events[1],"Event : Null","Position : Null","Position : Null","Position : Null")
                    viewModel.updateEvents(data)
                }else{
                    val data = EventData(events[0],events[1],events[2],"Position : Null","Position : Null","Position : Null")
                    viewModel.updateEvents(data)
                }
            }
        }

        viewModel.success.observe(viewLifecycleOwner,{
            if (it == 5){

            }
        })
        viewModel.error.observe(viewLifecycleOwner,{
            Toast.makeText(requireContext(),"Submit Failed",Toast.LENGTH_LONG).show()
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}