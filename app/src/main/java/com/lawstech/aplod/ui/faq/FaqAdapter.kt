package com.lawstech.aplod.ui.faq

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lawstech.aplod.data.source.local.entity.PasalEntity
import com.lawstech.aplod.databinding.ItemPasalBinding

class FaqAdapter : RecyclerView.Adapter<FaqAdapter.PasalViewHolder>() {
    private var listPasal = ArrayList<PasalEntity>()

    fun setPasal(pasal: List<PasalEntity>?) {
        if (pasal == null) return
        this.listPasal.clear()
        this.listPasal.addAll(pasal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqAdapter.PasalViewHolder {
        val itemPasalBinding = ItemPasalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PasalViewHolder(itemPasalBinding)
    }

    override fun onBindViewHolder(holder: FaqAdapter.PasalViewHolder, position: Int) {
        val pasal = listPasal[position]
        holder.bind(pasal)
    }

    override fun getItemCount(): Int = listPasal.size

    class PasalViewHolder(private val binding: ItemPasalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pasal: PasalEntity) {
            with(binding) {
                txtNamaPasal.text = pasal.namaPasal
                txtNomorPasal.text = pasal.nomorPasal
                txtPenjelasanPasal.text = pasal.penjelasanPasal
            }
        }
    }
}