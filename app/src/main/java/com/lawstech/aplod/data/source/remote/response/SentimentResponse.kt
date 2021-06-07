package com.lawstech.aplod.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SentimentResponse (

    @field:SerializedName("Kalimat")
    val Kalimat: String,

    @field:SerializedName("Sentimen")
    val Sentimen: String,

    @field:SerializedName("Hasil")
    val Hasil: Double
        )