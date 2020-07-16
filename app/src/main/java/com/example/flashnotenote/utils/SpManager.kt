package com.example.flashnotenote.utils

import android.content.Context
import android.content.SharedPreferences

class SpManager(private val context: Context) {
    private var mSettings: SharedPreferences? = context.getSharedPreferences("Note", Context.MODE_PRIVATE)
    private var mEditor: SharedPreferences.Editor? = mSettings?.let {
        it.edit()
    }

    fun getString(key: String?, defaultValue: String?): String? {
        return mSettings!!.getString(key, defaultValue)
    }

    fun putString(key: String?, value: String?) {
        mEditor!!.putString(key, value).apply()
    }

    fun getInt(key: String?, defaultValue: Int): Int {
        return mSettings!!.getInt(key, defaultValue)
    }

    fun putBoolean(key: String?, value: Boolean) {
        mEditor!!.putBoolean(key, value).apply()
    }

    fun getBoolean(key: String?, defaultValue: Boolean): Boolean {
        return mSettings!!.getBoolean(key, defaultValue)
    }

    fun putInt(key: String?, value: Int) {
        mEditor!!.putInt(key, value).apply()
    }

    fun removeKey(key: String?) {
        mEditor!!.remove(key).apply()
    }

    operator fun contains(key: String?): Boolean {
        return mSettings!!.contains(key)
    }

    companion object {
        fun getInstance(context: Context) = SpManager(context)
    }

}