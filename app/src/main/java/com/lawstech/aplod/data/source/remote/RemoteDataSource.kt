package com.lawstech.aplod.data.source.remote

import android.util.Log
import com.lawstech.aplod.data.source.remote.Api.ApiConfig
import com.lawstech.aplod.data.source.remote.response.SentimentResponse
import com.lawstech.aplod.utils.JsonHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getSentiment(kalimat: String, callback: LoadSentiment) {
        ApiConfig.getApiService().getSentiment(kalimat)
            .enqueue(object : Callback<SentimentResponse> {
                override fun onResponse(
                    call: Call<SentimentResponse>,
                    response: Response<SentimentResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callback.sentimentResult(it) }
                    }
                }

                override fun onFailure(call: Call<SentimentResponse>, t: Throwable) {
                    Log.e("Gagal", t.toString())
                }
            })
    }

    interface LoadSentiment {
        fun sentimentResult(sentimentResponse: SentimentResponse)
    }
}