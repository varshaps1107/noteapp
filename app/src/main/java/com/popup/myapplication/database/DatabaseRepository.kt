package com.example.mynote.database

import androidx.lifecycle.LiveData
import com.example.mynote.models.AppNote

interface DatabaseRepository {
    val allNotes: LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess: () -> Unit)
    suspend fun delete(note: AppNote, onSuccess: () -> Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {}

    fun signOut() {}
    // добавляем пустую реализацию чтобы
    // в реализующих этот интерфейс классах необязательно нужно
    // было эти функции реализовывать, ведь при подключении бд room реализация
    // этих ф-й не нужна
}