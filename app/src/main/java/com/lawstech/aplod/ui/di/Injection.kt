package com.lawstech.aplod.ui.di

import android.content.Context
import com.lawstech.aplod.data.AplodRepository
import com.lawstech.aplod.data.source.remote.RemoteDataSource
import com.lawstech.aplod.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AplodRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return AplodRepository.getInstance(remoteDataSource)
    }
}