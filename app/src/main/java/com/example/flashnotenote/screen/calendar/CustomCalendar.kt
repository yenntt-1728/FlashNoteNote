package com.example.flashnotenote.screen.calendar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flashnotenote.R
import com.example.flashnotenote.adapter.CalendarAdapter
import com.example.flashnotenote.databinding.CustomCalendarBinding
import com.example.flashnotenote.model.Events
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CustomCalendar : LinearLayout {

    private lateinit var calendar : Calendar
    private lateinit var listEvent : MutableList<Events>
    private  lateinit var listDate : MutableList<Date>
    private lateinit var listDay : MutableList<Int>
    private lateinit var binding : CustomCalendarBinding
    private lateinit var simpleDateFormat : SimpleDateFormat
    private var calendarAdapter : CalendarAdapter? = null

    constructor(context: Context) : super(context){
        initCalendar()
    }

    constructor (context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        initCalendar()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        initCalendar()
    }

    private fun initCalendar(){
        calendar = Calendar.getInstance(Locale.ENGLISH)
        listEvent = mutableListOf()
        listDate = mutableListOf()
        listDay = mutableListOf()
        binding = CustomCalendarBinding.inflate(LayoutInflater.from(context), this, true)
        binding.listener = this
        setUpDate(binding.textCurrentDate)
    }

     fun setOnClickButton(view : View){
        when (view.id) {
            R.id.imagePrevious -> {
                calendar.add(Calendar.MONTH, -1)
                setUpDate(binding.textCurrentDate)
            }
            R.id.imageNext -> {
                calendar.add(Calendar.MONTH, +1)
                setUpDate(binding.textCurrentDate)
            }
        }
    }

    fun setUpDate(currentTime : AppCompatTextView){
        val dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH)
        currentTime.text = dateFormat.format(calendar.time)
        listDate.clear()
        val calendarOfMonth : Calendar = calendar.clone() as Calendar
        calendarOfMonth.set(Calendar.DAY_OF_MONTH, 1)
        val firstDayOfMonth : Int = calendarOfMonth.get(Calendar.DAY_OF_WEEK) -1
        calendarOfMonth.add(Calendar.DAY_OF_MONTH, -firstDayOfMonth)
        while (listDate.size < maxDay){
            listDate.add(calendarOfMonth.time)
            listDay.add(calendarOfMonth.get(Calendar.DAY_OF_MONTH))
            calendarOfMonth.add(Calendar.DAY_OF_MONTH, 1)
        }
        if (calendarAdapter != null){
            calendarAdapter!!.clear()
            calendarAdapter = CalendarAdapter(context, listDay, calendar, listEvent, listDate)
            binding.gridView.adapter = calendarAdapter
            binding.gridView.layoutManager = GridLayoutManager(context, 7)
        }else {
            calendarAdapter = CalendarAdapter(context, listDay, calendar, listEvent, listDate)
            binding.gridView.adapter = calendarAdapter
            binding.gridView.layoutManager = GridLayoutManager(context, 7)
        }
    }

    fun setBackgroundCurrentDate() : Boolean{
        return calendarAdapter!!.setBackgroundCurrentDate(context, listDate, rootView)
    }

    companion object {
        val maxDay = 42
    }
}