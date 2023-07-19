package com.example.mynote.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mynote.database.room.AppRoomDatabase
import com.example.mynote.database.room.AppRoomRepository
import com.example.mynote.utilits.*

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }
}