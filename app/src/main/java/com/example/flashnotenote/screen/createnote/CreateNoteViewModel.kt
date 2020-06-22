package com.example.flashnotenote.screen.createnote

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.flashnotenote.database.AppDataBase
import com.example.flashnotenote.database.EntityNote
import com.example.flashnotenote.database.NoteDaoImpl
import com.example.flashnotenote.database.NoteDataSourceImpl
import com.example.flashnotenote.model.Note

class CreateNoteViewModel(private val context: Context) :  ViewModel(){
//    private lateinit var noteDataSourceImpl: NoteDataSourceImpl
//    private lateinit var appDatabase : AppDataBase
//
//    fun saveNote(note : Note){
//        appDatabase = AppDataBase.getInstance(context)
//        noteDataSourceImpl = NoteDataSourceImpl.newInstance(NoteDaoImpl.getInstance(appDatabase.noteDao()))
//        noteDataSourceImpl.insertNote(
//            EntityNote(
//            title = note.title,
//            content = note.content,
//            sound = note.sound,
//            color = note.color,
//            date = note.date,
//            time = note.time)
//        )
//        Toast.makeText(context, "Saved note", Toast.LENGTH_SHORT).show()
//    }
}