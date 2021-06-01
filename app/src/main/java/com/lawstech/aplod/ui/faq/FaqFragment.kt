package com.lawstech.aplod.ui.faq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lawstech.aplod.databinding.FragmentFaqBinding

class FaqFragment : Fragment() {

    private lateinit var faqViewModel: FaqViewModel
    private lateinit var fragmentFaqBinding: FragmentFaqBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFaqBinding = FragmentFaqBinding.inflate(layoutInflater, container, false)
        return fragmentFaqBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            faqViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[FaqViewModel::class.java]
            val pasal = faqViewModel.getPasal()

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