package com.lawstech.aplod.ui.about_us

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lawstech.aplod.R
import com.lawstech.aplod.data.source.local.entity.MemberEntity
import com.lawstech.aplod.databinding.ItemMemberBinding

class MemberAdapter : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>(){
    private var listMember = ArrayList<MemberEntity>()

    fun setMember(members: List<MemberEntity>?) {
        if (members == null) return
        this.listMember.clear()
        this.listMember.addAll(members)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val itemMemberBinding = ItemMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemberViewHolder(itemMemberBinding)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        val member = listMember[position]
        holder.bind(member)
    }

    override fun getItemCount(): Int = listMember.size

    class MemberViewHolder(private val binding: ItemMemberBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(member: MemberEntity) {
            with(binding) {
                txtFullName.text = member.memberName
                txtId.text = member.memberId
                txtPath.text = member.memberPath

                Glide.with(itemView.context)
                        .load(member.memberPhoto)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_error)
                        .into(imgMemberPhoto)
            }
        }
    }
}