package com.mahibul.dccdigitalweek.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mahibul.dccdigitalweek.R
import com.mahibul.dccdigitalweek.databinding.FragmentGalleryBinding
import com.smarteist.autoimageslider.SliderAnimations

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null

    private var images = arrayOf<Int>(R.drawable.pic,R.drawable.picall,R.drawable.pic1,R.drawable.pic2,R.drawable.img3_3,R.drawable.img3_5
    ,R.drawable.pic2_2,R.drawable.pic3_1,R.drawable.pic4,R.drawable.pic5,R.drawable.pic3_2
    ,R.drawable.pic5_2,R.drawable.img5_5,R.drawable.pic6,R.drawable.pic6_2,R.drawable.img6_6,R.drawable.pic7,R.drawable.pic7_1,R.drawable.img7_1,R.drawable.pic8,
    R.drawable.img8_8,R.drawable.pic9,R.drawable.img9_9,R.drawable.pic11,R.drawable.pic11_2,R.drawable.pic11_3,
    R.drawable.pic12_2,R.drawable.pic13,R.drawable.pic18)

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // image slider 1
        val adapter = SliderAdapter(images)
        _binding!!.imageSlider.setSliderAdapter(adapter)
        _binding!!.imageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        _binding!!.imageSlider.startAutoCycle()
        //image slider 2
        _binding!!.imageSlider1.setSliderAdapter(adapter)
        _binding!!.imageSlider1.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        _binding!!.imageSlider1.startAutoCycle()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}