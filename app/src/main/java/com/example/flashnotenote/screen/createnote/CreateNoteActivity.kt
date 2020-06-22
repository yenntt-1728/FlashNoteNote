package com.example.flashnotenote.screen.createnote

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.flashnotenote.R
import com.example.flashnotenote.database.AppDataBase
import com.example.flashnotenote.database.EntityNote
import com.example.flashnotenote.database.NoteDaoImpl
import com.example.flashnotenote.database.NoteDataSourceImpl
import com.example.flashnotenote.databinding.ActivityCreateNoteBinding
import com.example.flashnotenote.model.Note
import com.example.flashnotenote.screen.moreinfo.MoreInfoActivity
import kotlinx.android.synthetic.main.activity_create_note.*

class CreateNoteActivity : AppCompatActivity() {
    private lateinit var createNoteViewModel: CreateNoteViewModel
    private lateinit var binding : ActivityCreateNoteBinding
    private lateinit var noteDataSourceImpl: NoteDataSourceImpl
    private lateinit var appDatabase : AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)
        toolbarCreateNote.title = "New note"
        setSupportActionBar(toolbarCreateNote)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        imageSave.setOnClickListener{
            appDatabase = AppDataBase.getInstance(applicationContext)
            noteDataSourceImpl = NoteDataSourceImpl.newInstance(NoteDaoImpl.getInstance(appDatabase.noteDao()))
            noteDataSourceImpl.insertNote(
                EntityNote(
                    title = textTitle.text.toString(),
                    content = textContent.text.toString(),
                    sound = "",
                    color = "",
                    date = "17-6-2020",
                    time = "00:00")
            )
            Toast.makeText(applicationContext, "Saved note", Toast.LENGTH_SHORT).show()
        }
        imageMoreInfo.setOnClickListener {
           val intent = Intent(this, MoreInfoActivity::class.java)
            startActivity(intent)
        }
    }

//    fun saveNote(){
//        appDatabase = AppDataBase.getInstance(applicationContext)
//        noteDataSourceImpl = NoteDataSourceImpl.newInstance(NoteDaoImpl.getInstance(appDatabase.noteDao()))
//        noteDataSourceImpl.insertNote(
//            EntityNote(
//                title = textTitle.text.toString(),
//                content = textContent.text.toString(),
//                sound = "",
//                color = "",
//                date = "17-6-2020",
//                time = "00:00")
//        )
//        Toast.makeText(applicationContext, "Saved note", Toast.LENGTH_SHORT).show()
//    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}