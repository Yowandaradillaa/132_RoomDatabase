package com.example.myroom.room

import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface SiswaDao {
    @Query(value = "SELECT * from tblSiswa ORDER BY nama ASC")
    fun getAllSiswa():Flow<List<Siswa>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(siswa: Siswa)
}