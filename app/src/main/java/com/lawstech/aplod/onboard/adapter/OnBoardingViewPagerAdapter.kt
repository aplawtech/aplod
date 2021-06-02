package com.lawstech.aplod.onboard.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.lawstech.aplod.R
import com.lawstech.aplod.onboard.onBoardModel.OnBoardingData

class OnBoardingViewPagerAdapter(private var context: Context, private var onBoardingData: List<OnBoardingData>): PagerAdapter() {

    override fun getCount(): Int {
        return onBoardingData.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    @SuppressLint("InflateParams")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.onboarding_screen_layout, null)

        val imageView: ImageView = view.findViewById(R.id.imageView)
        val desc: TextView = view.findViewById(R.id.descView)

        imageView.setImageResource(onBoardingData[position].image)
        desc.text = onBoardingData[position].desc

        container.addView(view)

        return view
    }
}