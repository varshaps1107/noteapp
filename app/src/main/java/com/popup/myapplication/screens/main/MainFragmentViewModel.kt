package com.example.mynote.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mynote.utilits.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes

    fun signOut() {
        REPOSITORY.signOut()
    }
}