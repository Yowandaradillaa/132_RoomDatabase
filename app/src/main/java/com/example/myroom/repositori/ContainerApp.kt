package com.example.myroom.repositori

import android.content.Context
import com.example.myroom.room.DataBaseSiswa
import com.example.myroom.room.SiswaDao

interface ContainerApp {
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(private val context: Context) : ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(
            siswaDao = DataBaseSiswa.getDataBase(context).siswaDao()
        )
    }
}
