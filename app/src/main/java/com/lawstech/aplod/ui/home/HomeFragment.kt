package com.lawstech.aplod.ui.home

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lawstech.aplod.databinding.FragmentHomeBinding
import com.lawstech.aplod.viewmodel.ViewModelFactory
import java.util.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var input: String

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

        checkValidationToSend()

        fragmentHomeBinding.btnCheck.setOnClickListener {
            checkSentiment()
        }

        fragmentHomeBinding.btnSend.setOnClickListener {
            onShareClick()
        }
    }

    private fun onShareClick() {
        input = fragmentHomeBinding.inputComment.text.toString()
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(input)
                .startChooser()
        }
    }


    @SuppressLint("SetTextI18n")
    private fun checkSentiment() {
        hideKeyboard()

        input = fragmentHomeBinding.inputComment.text.toString()

        val labelTiga = arrayOf("pemerintah","pemerintahan","KPK", "polisi", "pejabat")
        val labelEmpat = arrayOf("kamu", "dia", "seperti")
        val labelLima = arrayOf("bunuh", "laporin", "hancur", "kubunuh", "sebarin", "menyebarkan","bongkar", "hilang")
        val labelEnam = arrayOf("kristen","islam","buddha","konghucu","budha","hindu","katolik", "agama")

        fragmentHomeBinding.progressBar.visibility = View.VISIBLE
        fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
        fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
        fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
        fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
        fragmentHomeBinding.undangUndang.visibility = View.INVISIBLE

        input = fragmentHomeBinding.inputComment.text.toString()
        if (input.isEmpty()) {
            fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
            fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
            fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
            fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
            fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
            fragmentHomeBinding.undangUndang.visibility = View.INVISIBLE
        }

        val factory = ViewModelFactory.getInstance(requireContext())
        homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        homeViewModel.getSentiment(input).observe(viewLifecycleOwner, { sentiment ->
            fragmentHomeBinding.tvSentimen.text = sentiment.sentimen.toString()
            when (fragmentHomeBinding.tvSentimen.text) {
                "Negatif" -> {

                    fragmentHomeBinding.imgNotOk.visibility = View.VISIBLE
                    fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
                    fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                    fragmentHomeBinding.undangUndang.visibility = View.INVISIBLE

                    for (badWords in labelTiga.indices){
                        val badWord = labelTiga[badWords]
                        if (input.toLowerCase(Locale.ROOT).contains(badWord)){
                            fragmentHomeBinding.imgNotOk.visibility = View.VISIBLE
                            fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
                            fragmentHomeBinding.langgarPasalDetected.visibility = View.VISIBLE
                            fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
                            fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                            fragmentHomeBinding.undangUndang.text = "Menghina Pemerintah atau Badan Umum : Pasal 207 KUHP & Pasal 208 KUHP"
                            fragmentHomeBinding.undangUndang.visibility = View.VISIBLE
                        }
                    }
                    for (badWords in labelEmpat.indices){
                        val badWord = labelEmpat[badWords]
                        if (input.toLowerCase(Locale.ROOT).contains(badWord)){
                            fragmentHomeBinding.imgNotOk.visibility = View.VISIBLE
                            fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
                            fragmentHomeBinding.langgarPasalDetected.visibility = View.VISIBLE
                            fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
                            fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                            fragmentHomeBinding.undangUndang.text = "Menghina atau Mencemari Nama Baik Orang Lain : Pasal 27 ayat (3) UU ITE"
                            fragmentHomeBinding.undangUndang.visibility = View.VISIBLE
                        }
                    }
                    for (badWords in labelLima.indices){
                        val badWord = labelLima[badWords]
                        if (input.toLowerCase(Locale.ROOT).contains(badWord)){
                            fragmentHomeBinding.imgNotOk.visibility = View.VISIBLE
                            fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
                            fragmentHomeBinding.langgarPasalDetected.visibility = View.VISIBLE
                            fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
                            fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                            fragmentHomeBinding.undangUndang.text = "Mengancam Orang Lain : Pasal 29 UU ITE"
                            fragmentHomeBinding.undangUndang.visibility = View.VISIBLE
                        }
                    }
                    for (badWords in labelEnam.indices){
                        val badWord = labelEnam[badWords]
                        if (input.toLowerCase(Locale.ROOT).contains(badWord)){
                            fragmentHomeBinding.imgNotOk.visibility = View.VISIBLE
                            fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
                            fragmentHomeBinding.langgarPasalDetected.visibility = View.VISIBLE
                            fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
                            fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                            fragmentHomeBinding.undangUndang.text = " Menyinggung SARA : Pasal 28 ayat (2) UU ITE"
                            fragmentHomeBinding.undangUndang.visibility = View.VISIBLE
                        }
                    }
                }
                "Positif" -> {
                    fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.imgOk.visibility = View.VISIBLE
                    fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.btnSend.visibility = View.VISIBLE
                    fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                    fragmentHomeBinding.undangUndang.visibility = View.INVISIBLE
                }
                else -> {
                    fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
                    fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
                    fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
                    fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                    fragmentHomeBinding.undangUndang.visibility = View.INVISIBLE
                }
            }
        })
    }

    private fun checkValidationToSend(){
        fragmentHomeBinding.inputComment.addTextChangedListener(object : TextWatcher
        {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                fragmentHomeBinding.imgNotOk.visibility = View.INVISIBLE
                fragmentHomeBinding.imgOk.visibility = View.INVISIBLE
                fragmentHomeBinding.langgarPasalDetected.visibility = View.INVISIBLE
                fragmentHomeBinding.btnSend.visibility = View.INVISIBLE
                fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
                fragmentHomeBinding.undangUndang.visibility = View.INVISIBLE
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
