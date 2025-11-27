package com.example.myroom.repositori

import com.example.myroom.room.Siswa

interface RepositoriSiswa{
    fun getAllSiswaStream():
            suspend fun insertSiswa(siswa: Siswa)
}

