package com.example.flashnotenote.screen.calendar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import com.applandeo.materialcalendarview.EventDay
import com.example.flashnotenote.R
import com.example.flashnotenote.databinding.ActivityCalendarBinding
import com.example.flashnotenote.screen.createnote.CreateNoteActivity
import com.example.flashnotenote.utils.SpManager
import kotlinx.android.synthetic.main.activity_calendar.*
import kotlinx.android.synthetic.main.item_calendar.*
import java.util.*
import kotlin.math.log


class CalendarActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        toolBarCalendar.title = "Calendar"
        setSupportActionBar(toolBarCalendar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val binding : ActivityCalendarBinding = DataBindingUtil.setContentView(this, R.layout.activity_calendar)
        binding.listener = this
        onClickNote()
        setBackgroundCurrentDay()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun onClickNote(){
        imageCreateNoteCalendar.setOnClickListener {
            val intent = Intent(this, CreateNoteActivity::class.java)
            val bundle = Bundle()
            bundle.putString("date", SpManager.getInstance(applicationContext).getString("calendar date", ""))
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    fun setBackgroundCurrentDay() : Boolean{
        return calendarView.setBackgroundCurrentDate()
    }
}