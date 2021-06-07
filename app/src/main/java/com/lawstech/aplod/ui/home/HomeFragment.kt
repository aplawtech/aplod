package com.lawstech.aplod.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lawstech.aplod.databinding.FragmentHomeBinding
import com.lawstech.aplod.viewmodel.ViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var kalimat: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding.btnCheck.setOnClickListener {
            checkSentiment()
        }
        fragmentHomeBinding.btnShare.setOnClickListener {
            onShareClick()
        }
    }

    private fun onShareClick() {
        kalimat = fragmentHomeBinding.inputComment.text.toString()
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(kalimat)
                .startChooser()
        }
    }

    private fun checkSentiment() {
        kalimat = fragmentHomeBinding.inputComment.text.toString()
        val factory = ViewModelFactory.getInstance(requireContext())
        homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        homeViewModel.getSentiment(kalimat).observe(viewLifecycleOwner, { sentiment ->
            fragmentHomeBinding.tvSentimen.text = sentiment.sentimen.toString()
        })
    }

}