package com.example.myroom.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myroom.repositori.RepositoriSiswa

class HomeViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5000L
    }

}