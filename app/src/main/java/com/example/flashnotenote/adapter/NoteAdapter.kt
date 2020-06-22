package com.example.flashnotenote.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.flashnotenote.R
import com.example.flashnotenote.BR
import com.example.flashnotenote.databinding.ItemRecyclerNoteBinding
import com.example.flashnotenote.model.Note

class NoteAdapter(private val listNotes: ArrayList<Note>, private val context : Context) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    class NoteViewHolder(private val binding : ItemRecyclerNoteBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindData(note : Note){
            binding.setVariable(BR.note, note)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding : ItemRecyclerNoteBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.item_recycler_note, parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bindData(listNotes[position])
    }

}