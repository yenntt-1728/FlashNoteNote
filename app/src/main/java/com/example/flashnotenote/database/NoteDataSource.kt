package com.example.flashnotenote.database

import io.reactivex.Flowable

interface NoteDataSource {
    fun getAllNote() : Flowable<List<EntityNote>>

    fun insertNote(note : EntityNote)

    fun deleteNote(note : EntityNote)
}