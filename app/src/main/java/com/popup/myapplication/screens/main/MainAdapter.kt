package com.example.mynote.screens.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynote.models.AppNote
import com.popup.myapplication.R
import com.popup.myapplication.databinding.NoteItemBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()

    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = NoteItemBinding.bind(view)
        val nameNote: TextView = binding.itemNoteName
        val textNote: TextView = binding.itemNoteText
    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener {
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.textNote.text = mListNotes[position].text
        holder.nameNote.text = mListNotes[position].name
    }

    override fun getItemCount(): Int = mListNotes.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<AppNote>) {
        mListNotes = list
        notifyDataSetChanged()
    }
}