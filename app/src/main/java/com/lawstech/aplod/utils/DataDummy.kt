package com.lawstech.aplod.utils

import com.lawstech.aplod.R
import com.lawstech.aplod.data.source.local.entity.MemberEntity
import com.lawstech.aplod.data.source.local.entity.PasalEntity

object DataDummy {

    fun generateDummyMembers(): ArrayList<MemberEntity> {
        val members = ArrayList<MemberEntity>()

        members.add(MemberEntity(
                "C0121288",
                "Adimas Fachri Ranunegoro",
                "Cloud Computing",
                "Universitas Telkom Bandung",
                R.drawable.fachri
        ))
        members.add(
            MemberEntity(
                "C0121278",
                "Agnesia Indryany Mangopo",
                "Cloud Computing",
                "Universitas Telkom Bandung",
                R.drawable.agnes
        ))
        members.add(MemberEntity(
                "A0121283",
                "Alex Lianardo",
                "Mobile Development",
                "Universitas Telkom Bandung",
                R.drawable.alex
        ))
        members.add(MemberEntity(
                "A2242180",
                "Annisaa Utami",
                "Mobile Development",
                "UIN Syarif Hidayatullah Jakarta",
                R.drawable.icha
        ))
        members.add(MemberEntity(
                "M0040231",
                "Muhammad Bondan Vitto Ramadhan",
                "Machine Learning",
                "Institut Teknologi Sepuluh Nopember Surabaya",
                R.drawable.bondan
        ))
        members.add(MemberEntity(
                "M0121267",
                "Muhammad Ikhwan Khalid Nasution",
                "Machine Learning",
                "Universitas Telkom Bandung",
                R.drawable.ikhwan
        ))

        return members
    }

    fun generateDummyPasal(): ArrayList<PasalEntity> {
        val pasal = ArrayList<PasalEntity>()

        pasal.add(
            PasalEntity(
            1,
            "Menghina Pemerintah atau Badan Umum",
        "Pasal 207 KUHP",
                "Barang siapa dengan sengaja di muka umum dengan lisan atau tulisan menghina suatu penguasa atau badan umum yang ada di Indonesia, diancam dengan pidana penjara paling lama satu tahun enam bulan atau pidana denda paling banyak empat ribu lima ratus rupiah."
        ))
        pasal.add(
            PasalEntity(
            2,
                "Menghina Pemerintah atau Badan Umum",
                "Pasal 208 KUHP",
                "Barang siapa dengan sengaja di muka umum dengan lisan atau tulisan menghina suatu penguasa atau hadan umum yang ada di Indonesia, diancam dengan pidana penjara paling lama satu tahun enam bulan atau pidana denda paling banyak empat ribu lima ratus rupiah."
        ))
        pasal.add(
            PasalEntity(
            3,
                "Menghina atau Mencemari Nama Baik Orang Lain",
                "Pasal 27 ayat (3) UU ITE",
                "Setiap Orang dengan sengaja dan tanpa hak mendistribusikan dan/atau mentransmisikan dan/atau membuat dapat diaksesnya Informasi Elektronik dan/atau Dokumen Elektronik yang memiliki muatan penghinaan dan/atau pencemaran nama baik."
        ))
        pasal.add(
            PasalEntity(
            4,
                "Mengancam Orang Lain",
                "Pasal 29 UU ITE",
                "Setiap Orang dengan sengaja dan tanpa hak mengirimkan Informasi Elektronik dan/atau Dokumen Elektronik yang berisi ancaman kekerasan atau menakut-nakuti yang ditujukan secara pribadi."
        ))
        pasal.add(
            PasalEntity(
            5,
                "Menyinggung SARA",
                "Pasal 28 ayat (2) UU ITE",
                "Setiap Orang dengan sengaja dan tanpa hak menyebarkan informasi yang ditujukan untuk menimbulkan rasa kebencian atau permusuhan individu dan/atau kelompok masyarakat tertentu berdasarkan atas suku, agama, ras, dan antargolongan (SARA)."
        ))

        return pasal
    }
}