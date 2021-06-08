package com.lawstech.aplod.data

import androidx.lifecycle.LiveData
import com.lawstech.aplod.data.source.local.entity.MemberEntity
import com.lawstech.aplod.data.source.local.entity.PasalEntity
import com.lawstech.aplod.data.source.local.entity.SentimentEntity

interface IAplodDataSource {

    fun getSentiment(kalimat: String): LiveData<SentimentEntity>
}