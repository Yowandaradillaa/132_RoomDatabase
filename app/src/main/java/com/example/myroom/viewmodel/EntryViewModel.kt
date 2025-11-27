package com.example.myroom.viewmodel

import com.example.myroom.room.Siswa

data class DetailSiswa(
    val id : Int = 0,
    val nama : String,
    val alamat : String,
    val telpon : String
)

fun DetailSiswa.toSiswa(): Siswa = Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

fun Siswa.toUiStateSiswa(isEntryValid: Boolean = false): UIStateSiswa = UIStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)

