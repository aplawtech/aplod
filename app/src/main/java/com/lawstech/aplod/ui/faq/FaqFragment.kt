package com.lawstech.aplod.ui.faq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lawstech.aplod.R
import com.lawstech.aplod.databinding.FragmentFaqBinding
import com.lawstech.aplod.utils.DataDummy

class FaqFragment : Fragment() {

    private lateinit var fragmentFaqBinding: FragmentFaqBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFaqBinding = FragmentFaqBinding.inflate(layoutInflater, container, false)
        return fragmentFaqBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val pasal = DataDummy.generateDummyPasal()

            val pasalAdapter = FaqAdapter()
            pasalAdapter.setPasal(pasal)

            with(fragmentFaqBinding.rvPasal) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = pasalAdapter
            }
        }
    }
}