package com.lawstech.aplod.ui.about_us

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lawstech.aplod.databinding.FragmentAboutUsBinding

class AboutUsFragment : Fragment() {

    private lateinit var fragmentAboutUsBinding: FragmentAboutUsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentAboutUsBinding = FragmentAboutUsBinding.inflate(layoutInflater, container, false)
        return fragmentAboutUsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aboutUsPageAdapter = context?.let { AboutUsPageAdapter(it, this.childFragmentManager) }
        fragmentAboutUsBinding.viewPager.adapter = aboutUsPageAdapter
        fragmentAboutUsBinding.tabs.setupWithViewPager(fragmentAboutUsBinding.viewPager)
    }
}