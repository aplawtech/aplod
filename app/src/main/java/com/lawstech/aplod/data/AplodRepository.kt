package com.lawstech.aplod.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lawstech.aplod.data.source.local.entity.SentimentEntity
import com.lawstech.aplod.data.source.remote.RemoteDataSource
import com.lawstech.aplod.data.source.remote.response.SentimentResponse

class AplodRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    IAplodDataSource {

    companion object {
        @Volatile
        private var instance: AplodRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): AplodRepository =
            instance ?: synchronized(this) {
                instance ?: AplodRepository(remoteDataSource).apply { instance = this }
            }
    }

    override fun getSentiment(kalimat: String): LiveData<SentimentEntity> {
        val sentimentResult = MutableLiveData<SentimentEntity>()
        remoteDataSource.getSentiment(
            kalimat, object : RemoteDataSource.LoadSentiment {
                override fun sentimentResult(sentimentResponse: SentimentResponse) {
                    val responseResultSentiment = SentimentEntity(
                        sentimentResponse.Kalimat,
                        sentimentResponse.Sentimen,
                        sentimentResponse.Hasil
                    )
                    sentimentResult.postValue(responseResultSentiment)
                }

            }
        )
        return sentimentResult
    }
}