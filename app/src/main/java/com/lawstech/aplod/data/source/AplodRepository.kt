package com.lawstech.aplod.data.source

import com.lawstech.aplod.data.source.local.entity.MemberEntity
import com.lawstech.aplod.data.source.local.entity.PasalEntity
import com.lawstech.aplod.data.source.remote.RemoteDataSource

class AplodRepository private constructor(private val remoteDataSource: RemoteDataSource) : AplodDataSource {

//    companion object {
//        @Volatile
//        private var instance: AplodRepository? = null
//
//        fun getInstance(remoteData: RemoteDataSource): AplodRepository =
//            instance ?: synchronized(this) {
//                instance ?: AplodRepository(remoteData).apply { instance = this }
//            }
//    }
//
//    override fun getAllMembers(): List<MemberEntity> {
//        val memberResponses = remoteDataSource.getAllMembers()
//        val memberList = ArrayList<MemberEntity>()
//        for (response in memberResponses) {
//            val member = MemberEntity(
//                response.memberId,
//                response.memberName,
//                response.memberPath,
//                response.memberUniv,
//                response.memberPhoto!!.toInt())
//
//            memberList.add(member)
//        }
//        return memberList
//    }
//
//    override fun getAllPasal(): List<PasalEntity> {
//        val pasalResponses = remoteDataSource.getAllPasal()
//        val pasalList = ArrayList<PasalEntity>()
//        for (response in pasalResponses) {
//            val pasal = PasalEntity(
//                response.pasalId,
//                response.pasalJudul,
//                response.nomorPasal,
//                response.penjelasanPasal)
//
//            pasalList.add(pasal)
//        }
//        return pasalList
//    }
}