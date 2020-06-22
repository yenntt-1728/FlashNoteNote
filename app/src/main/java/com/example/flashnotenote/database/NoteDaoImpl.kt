package com.example.flashnotenote.database

import io.reactivex.Flowable

class NoteDaoImpl(private val noteDao: NoteDao) : NoteDataSource {
    override fun getAllNote(): Flowable<List<EntityNote>> {
        return noteDao.getAllNote()
    }

    override fun insertNote(note: EntityNote) {
        return noteDao.insertNote(note)
    }

    override fun deleteNote(note: EntityNote) {
        return noteDao.deleteNote(note)
    }

    companion object {
        var instance : NoteDaoImpl? = null
        fun getInstance(newsDao : NoteDao) : NoteDaoImpl {
            if (instance == null) {
                instance = NoteDaoImpl(newsDao)
            }
            return instance as NoteDaoImpl
        }
    }
}