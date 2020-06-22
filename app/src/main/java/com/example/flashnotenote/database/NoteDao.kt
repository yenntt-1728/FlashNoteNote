package com.example.flashnotenote.database

import androidx.room.*
import io.reactivex.Flowable

@Dao
interface NoteDao  {
    @Query("SELECT * FROM notes")
    fun getAllNote() : Flowable<List<EntityNote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(vararg note : EntityNote)

    @Delete
    fun deleteNote(vararg note : EntityNote)
}