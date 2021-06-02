package com.lawstech.aplod.ui.about_us.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lawstech.aplod.databinding.FragmentMemberBinding
import com.lawstech.aplod.ui.about_us.AboutUsViewModel
import com.lawstech.aplod.ui.about_us.MemberAdapter
import com.lawstech.aplod.utils.DataDummy

class MemberFragment : Fragment() {

    private lateinit var viewModel: AboutUsViewModel
    private var _fragmentMemberBinding: FragmentMemberBinding? = null
    private val binding get() = _fragmentMemberBinding

    private lateinit var adapter: MemberAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentMemberBinding = FragmentMemberBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[AboutUsViewModel::class.java]
            val members = viewModel.getMembers()

            adapter = MemberAdapter()
            adapter.setMember(members)

            binding?.rvMember?.layoutManager = LinearLayoutManager(context)
            binding?.rvMember?.setHasFixedSize(true)
            binding?.rvMember?.adapter = adapter
        }
    }

}