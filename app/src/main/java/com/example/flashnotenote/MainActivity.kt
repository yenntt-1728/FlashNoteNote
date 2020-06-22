package com.example.flashnotenote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.flashnotenote.adapter.NoteAdapter
import com.example.flashnotenote.database.EntityNote
import com.example.flashnotenote.model.Note
import com.example.flashnotenote.screen.calendar.CalendarActivity
import com.example.flashnotenote.screen.createnote.CreateNoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var noteAdapter : NoteAdapter
    private var listNotes: ArrayList<Note> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageCalendar.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }
        imageCreateNote.setOnClickListener {
            val intent = Intent(this, CreateNoteActivity::class.java)
            startActivity(intent)
        }
        viewModel = MainViewModel(applicationContext)
        viewModel.getListSave()
        viewModel.listNotesLiveData.observe(this, Observer {
            val arrayListNote = arrayListOf<Note>()
            for (note : EntityNote in it){
                val note = Note(
                    title = note.title,
                    content = note.content,
                    sound = note.sound,
                    date = note.date,
                    time = note.time
                )
                arrayListNote.add(note)
            }
            addAllNote(arrayListNote)
            noteAdapter = NoteAdapter(listNotes, applicationContext)
            recyclerNote.adapter = noteAdapter
        })
    }

    private fun addAllNote(arrayLisNote : ArrayList<Note>){
        listNotes.clear()
        listNotes.addAll(arrayLisNote)
    }
}