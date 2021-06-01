package com.lawstech.aplod.ui.faq

import androidx.lifecycle.ViewModel
import com.lawstech.aplod.data.source.local.entity.PasalEntity
import com.lawstech.aplod.utils.DataDummy

class FaqViewModel : ViewModel() {

    fun getPasal(): List<PasalEntity> = DataDummy.generateDummyPasal()
}