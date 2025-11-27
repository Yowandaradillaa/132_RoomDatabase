package com.example.myroom.room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Siswa:class], version = 1, exportSchema = false)
abstract class DataBaseSiswa : RoomDatabase() {
    abstract fun siswaDao() : SiswaDao

    companion object {
        @Volatile
        private var Instance: DataBaseSiswa? = null

        fun getDataBase(context : Context) : DataBaseSiswa {
            return  (Instance?: synchronized(lock = this)){
                Room.databaseBuilder(
                    context, klass = DataBaseSiswa::class.java,
                    name = "siswa_database")
                    .build().also {Instance=it}
            }
        }
    }
}