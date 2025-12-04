package com.example.myroom.viewmodel.provider

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myroom.repositori.AplikasiSiswa
import com.example.myroom.viewmodel.EntryViewModel
import com.example.myroom.viewmodel.HomeViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.myroom.view.DetailDataSiswa
import com.example.myroom.viewmodel.DetailViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {

        // HAPUS BARIS INI: val aplikasiSiswa = this.aplikasiSiswa()

        initializer {
            // Pindah variabel ke sini, di mana 'this' adalah CreationExtras
            val aplikasiSiswa = this.aplikasiSiswa()
            HomeViewModel(
                aplikasiSiswa.container.repositoriSiswa
            )
        }
        initializer {
            // Ulangi untuk EntryViewModel
            val aplikasiSiswa = this.aplikasiSiswa()
            EntryViewModel(
                aplikasiSiswa.container.repositoriSiswa
            )
        }

        initializer {
            DetailViewModel(savedStateHandle = this.createSavedStateHandle(),
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa)
        }
    }
}
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)