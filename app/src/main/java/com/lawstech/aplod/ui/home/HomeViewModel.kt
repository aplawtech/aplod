package com.lawstech.aplod.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lawstech.aplod.data.AplodRepository
import com.lawstech.aplod.data.source.local.entity.SentimentEntity

class HomeViewModel(private val mAplodRepository: AplodRepository) : ViewModel() {

    fun getSentiment(kalimat: String): LiveData<SentimentEntity> =
        mAplodRepository.getSentiment(kalimat)
}