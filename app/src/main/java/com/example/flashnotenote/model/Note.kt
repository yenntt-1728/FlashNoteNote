package com.example.flashnotenote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Note (
    var title : String? = null,
    var content : String ="",
    var color : String = "",
    var sound : String = "",
    var time: String = "",
    var date: String = ""
) : Parcelable