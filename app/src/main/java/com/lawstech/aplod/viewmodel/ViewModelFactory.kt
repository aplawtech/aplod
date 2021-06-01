package com.lawstech.aplod.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.lawstech.aplod.data.source.AplodRepository

class ViewModelFactory private constructor(private val mAplodRepository: AplodRepository) : ViewModelProvider.NewInstanceFactory() {

//    companion object {
//        @Volatile
//        private var instance: ViewModelFactory? = null
//
//        fun getInstance(context: Context): ViewModelFactory =
//            instance ?: synchronized(this) {
//                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
//                    instance = this
//                }
//            }
//    }
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        when {
//            modelClass.isAssignableFrom(FaqViewModel::class.java) -> {
//                return FaqViewModel(mAplodRepository) as T
//            }
//            modelClass.isAssignableFrom(MemberViewModel::class.java) -> {
//                return MemberViewModel(mAplodRepository) as T
//            }
//            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
//                return HomeViewModel(mAplodRepository) as T
//            }
//            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
//        }
//    }
}