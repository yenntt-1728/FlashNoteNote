package com.example.flashnotenote.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EntityNote::class], version = 3)
abstract class AppDataBase : RoomDatabase() {
    abstract fun noteDao() : NoteDao

    companion object {
        fun getInstance(context: Context) : AppDataBase {
            val db = Room.databaseBuilder(context, AppDataBase::class.java, "note_database")
                .allowMainThreadQueries().build()
            return db
        }
    }
}