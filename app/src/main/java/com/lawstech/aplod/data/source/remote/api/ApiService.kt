package com.lawstech.aplod.data.source.remote.Api

import com.lawstech.aplod.data.source.remote.response.SentimentResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("predict")
    fun getSentiment(
        @Field("text") text: String
    ): Call<SentimentResponse>
}