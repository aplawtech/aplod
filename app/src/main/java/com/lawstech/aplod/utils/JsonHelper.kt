package com.lawstech.aplod.utils

import android.content.Context

import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

//    private fun parsingFileToString(fileName: String): String? {
//        return try {
//            val `is` = context.assets.open(fileName)
//            val buffer = ByteArray(`is`.available())
//            `is`.read(buffer)
//            `is`.close()
//            String(buffer)
//
//        } catch (ex: IOException) {
//            ex.printStackTrace()
//            null
//        }
//    }
//
//    fun loadMembers(): List<MemberResponse> {
//        val memberList = ArrayList<MemberResponse>()
//        try {
//            val responseObject = JSONObject(parsingFileToString("MemberResponses.json").toString())
//            val listArray = responseObject.getJSONArray("members")
//            for (i in 0 until listArray.length()) {
//                val member = listArray.getJSONObject(i)
//
//                val id = member.getString("id")
//                val name = member.getString("name")
//                val path = member.getString("path")
//                val university = member.getString("university")
//                val photo = member.getString("photo")
//
//                val memberResponse = MemberResponse(id, name, path, university, photo)
//                memberList.add(memberResponse)
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        return memberList
//    }
//
//    fun loadPasal(): List<PasalResponse> {
//        val pasalList = ArrayList<PasalResponse>()
//        try {
//            val responseObject = JSONObject(parsingFileToString("PasalResponses.json").toString())
//            val listArray = responseObject.getJSONArray("pasal")
//            for (i in 0 until listArray.length()) {
//                val pasal = listArray.getJSONObject(i)
//
//                val id = pasal.getInt("id")
//                val judul = pasal.getString("judul")
//                val nomorPasal = pasal.getString("nomorPasal")
//                val penjelasan = pasal.getString("penjelasan")
//
//                val pasalResponse = PasalResponse(id, judul, nomorPasal, penjelasan)
//                pasalList.add(pasalResponse)
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        return pasalList
//    }
}