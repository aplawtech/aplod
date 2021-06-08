package com.lawstech.aplod.ui.home

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
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
        fragmentHomeBinding.btnSend.setOnClickListener {
            btnSendClick()
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
        hideKeyboard()
        fragmentHomeBinding.progressBar.visibility = View.VISIBLE
        fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
        fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
        fragmentHomeBinding.txtSentimen.visibility = View.INVISIBLE
        fragmentHomeBinding.tvAman.visibility = View.INVISIBLE
        fragmentHomeBinding.kataKasarDetected.visibility = View.INVISIBLE
        fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
        fragmentHomeBinding.aplod.visibility = View.INVISIBLE
        fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
        kalimat = fragmentHomeBinding.inputComment.text.toString()
        if (kalimat.isEmpty()) {
            fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
            fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
            fragmentHomeBinding.txtSentimen.visibility = View.INVISIBLE
            fragmentHomeBinding.tvAman.visibility = View.INVISIBLE
            fragmentHomeBinding.aplod.visibility = View.INVISIBLE
            fragmentHomeBinding.kataKasarDetected.visibility = View.INVISIBLE
            fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
            fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
            fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
        }

        val factory = ViewModelFactory.getInstance(requireContext())
        homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        homeViewModel.getSentiment(kalimat).observe(viewLifecycleOwner, { sentiment ->
            fragmentHomeBinding.tvSentimen.text = sentiment.sentimen.toString()
            when (fragmentHomeBinding.tvSentimen.text) {
                "Negatif" -> {
                    fragmentHomeBinding.imgNotOk.visibility = View.VISIBLE
                    fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.tvAman.visibility = View.INVISIBLE
                    fragmentHomeBinding.txtSentimen.visibility = View.VISIBLE
                    fragmentHomeBinding.kataKasarDetected.visibility = View.VISIBLE
                    fragmentHomeBinding.langgarPasalDetected.visibility = View.VISIBLE
                    fragmentHomeBinding.aplod.visibility = View.INVISIBLE
                    fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
                    fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                }
                "Positif" -> {
                    fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.imgOk.visibility = View.VISIBLE
                    fragmentHomeBinding.tvAman.visibility = View.VISIBLE
                    fragmentHomeBinding.txtSentimen.visibility = View.VISIBLE
                    fragmentHomeBinding.kataKasarDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.aplod.visibility = View.VISIBLE
                    fragmentHomeBinding.btnSend.visibility = View.VISIBLE
                    fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                }
                "Netral" -> {
                    fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.imgOk.visibility = View.VISIBLE
                    fragmentHomeBinding.tvAman.visibility = View.VISIBLE
                    fragmentHomeBinding.txtSentimen.visibility = View.VISIBLE
                    fragmentHomeBinding.kataKasarDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.aplod.visibility = View.VISIBLE
                    fragmentHomeBinding.btnSend.visibility = View.VISIBLE
                    fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                }
                else -> {
                    fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.tvAman.visibility = View.INVISIBLE
                    fragmentHomeBinding.txtSentimen.visibility = View.INVISIBLE
                    fragmentHomeBinding.kataKasarDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.aplod.visibility = View.INVISIBLE
                    fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
                    fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                }
            }
        })
    }

    private fun btnSendClick(){
        fragmentHomeBinding.progressBar.visibility = View.VISIBLE
        fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
        fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
        fragmentHomeBinding.tvAman.visibility = View.INVISIBLE
        fragmentHomeBinding.txtSentimen.visibility = View.INVISIBLE
        fragmentHomeBinding.kataKasarDetected.visibility = View.INVISIBLE
        fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
        fragmentHomeBinding.aplod.visibility = View.INVISIBLE
        fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
        kalimat = fragmentHomeBinding.inputComment.text.toString()
        if (kalimat.isEmpty()) {
            fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
            fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
            fragmentHomeBinding.tvAman.visibility = View.INVISIBLE
            fragmentHomeBinding.txtSentimen.visibility = View.INVISIBLE
            fragmentHomeBinding.aplod.visibility = View.INVISIBLE
            fragmentHomeBinding.kataKasarDetected.visibility = View.INVISIBLE
            fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
            fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
            fragmentHomeBinding.progressBar.visibility = View.INVISIBLE

        }
        val factory = ViewModelFactory.getInstance(requireContext())
        homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        homeViewModel.getSentiment(kalimat).observe(viewLifecycleOwner, { sentiment ->
            fragmentHomeBinding.tvSentimen.text = sentiment.sentimen.toString()
            when (fragmentHomeBinding.tvSentimen.text) {
                "Negatif" -> {
                    fragmentHomeBinding.imgNotOk.visibility = View.VISIBLE
                    fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.tvAman.visibility = View.INVISIBLE
                    fragmentHomeBinding.txtSentimen.visibility = View.VISIBLE
                    fragmentHomeBinding.kataKasarDetected.visibility = View.VISIBLE
                    fragmentHomeBinding.langgarPasalDetected.visibility = View.VISIBLE
                    fragmentHomeBinding.aplod.visibility = View.INVISIBLE
                    fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
                    fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                }
                "Positif" -> {
                    fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.imgOk.visibility = View.VISIBLE
                    fragmentHomeBinding.tvAman.visibility = View.VISIBLE
                    fragmentHomeBinding.txtSentimen.visibility = View.VISIBLE
                    fragmentHomeBinding.kataKasarDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.aplod.visibility = View.VISIBLE
                    fragmentHomeBinding.btnSend.visibility = View.VISIBLE
                    fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                    onShareClick()
                }
                "Netral" -> {
                    fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.imgOk.visibility = View.VISIBLE
                    fragmentHomeBinding.tvAman.visibility = View.VISIBLE
                    fragmentHomeBinding.txtSentimen.visibility = View.VISIBLE
                    fragmentHomeBinding.kataKasarDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.aplod.visibility = View.VISIBLE
                    fragmentHomeBinding.btnSend.visibility = View.VISIBLE
                    fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                    onShareClick()
                }
                else -> {
                    fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.tvAman.visibility = View.INVISIBLE
                    fragmentHomeBinding.txtSentimen.visibility = View.VISIBLE
                    fragmentHomeBinding.kataKasarDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.aplod.visibility = View.INVISIBLE
                    fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
                    fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                }
            }
        })
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
