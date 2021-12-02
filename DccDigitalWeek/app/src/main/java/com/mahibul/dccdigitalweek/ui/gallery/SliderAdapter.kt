package com.mahibul.dccdigitalweek.ui.gallery


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.mahibul.dccdigitalweek.R
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(val images: Array<Int>) : SliderViewAdapter<SliderAdapter.Holder>() {

    public class Holder(itemview : View) : SliderViewAdapter.ViewHolder(itemview){
        val image = itemview.findViewById(R.id.image_view) as ImageView
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): Holder {
        val view =  LayoutInflater.from(parent?.context).inflate(R.layout.slider_item,parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(viewHolder: Holder?, position: Int) {

        if (viewHolder != null) {
            viewHolder.image.setImageResource(images[position])
        }
    }
}