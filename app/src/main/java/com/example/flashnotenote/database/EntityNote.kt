package com.example.flashnotenote.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class EntityNote (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content : String,
    @ColumnInfo(name = "color")
    val color : Int,
    @ColumnInfo(name = "sound")
    val sound : String,
    @ColumnInfo(name = "date")
    val date : String,
    @ColumnInfo(name = "time")
    val time : String?
)
