package com.example.flashnotenote.database

import io.reactivex.Flowable

class NoteDataSourceImpl(private val noteDataSource: NoteDataSource) : NoteDataSource {
    override fun getAllNote(): Flowable<List<EntityNote>> {
        return noteDataSource.getAllNote()
    }

    override fun insertNote(note: EntityNote) {
        return noteDataSource.insertNote(note)
    }

    override fun deleteNote(note: EntityNote) {
        return noteDataSource.deleteNote(note)
    }

    companion object {
        fun newInstance(noteDataSource: NoteDataSource) : NoteDataSourceImpl{
            var noteDataRepo : NoteDataSourceImpl? = null
            if (noteDataRepo == null){
                noteDataRepo = NoteDataSourceImpl(noteDataSource)
            }
            return noteDataRepo
        }
    }
}