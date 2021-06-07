package com.lawstech.aplod.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SentimentEntity (
    var kalimat: String? = null,
    var sentimen: String? = null,
    var hasil: Double = 0.0
        ) : Parcelable