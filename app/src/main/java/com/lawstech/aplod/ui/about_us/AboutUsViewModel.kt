package com.lawstech.aplod.ui.about_us

import androidx.lifecycle.ViewModel
import com.lawstech.aplod.data.source.local.entity.MemberEntity
import com.lawstech.aplod.utils.DataDummy

class AboutUsViewModel() : ViewModel() {

    fun getMembers(): List<MemberEntity> = DataDummy.generateDummyMembers()
}