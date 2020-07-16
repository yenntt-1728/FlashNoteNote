package com.example.flashnotenote.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.flashnotenote.R
import com.example.flashnotenote.adapter.CalendarAdapter.CalendarViewHolder
import com.example.flashnotenote.databinding.CustomCalendarBinding
import com.example.flashnotenote.databinding.ItemCalendarBinding
import com.example.flashnotenote.model.Events
import com.example.flashnotenote.utils.SpManager
import java.text.SimpleDateFormat
import java.util.*

class CalendarAdapter(private val context: Context, private val listDay : MutableList<Int>,
                      private val currentDate : Calendar, listEvents : MutableList<Events>,
                      private val listDate: MutableList<Date>) :
    RecyclerView.Adapter<CalendarViewHolder>() {

    class CalendarViewHolder(private val binding: ItemCalendarBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(date: Int){
            binding.viewModel = date
            binding.executePendingBindings()
        }

        fun setOnClickItem(context: Context, position: Int, listDate: MutableList<Date>){
            binding.textViewDate.setOnClickListener {
                if (it.background == null){
                    it.background = ContextCompat.getDrawable(context,R.drawable.bg_button_calendar)
                    val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
                    SpManager.getInstance(context).putString("calendar date", simpleDateFormat.format(listDate[position]))
                }else {
                    it.background = null
                }
            }
        }

        fun setBackgroundCurrentDate(context: Context, listDate: MutableList<Date>){
            val calendar : Calendar = Calendar.getInstance()
            for (date : Date in listDate){
                if (calendar.time.date == date.date){
                    binding.textViewDate.background = ContextCompat.getDrawable(context,R.drawable.bg_button_calendar)
                    SpManager.getInstance(context).putString("calendar date", calendar.time.toString())
                    return
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val itemCalendarBinding : ItemCalendarBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.item_calendar, parent, false)
        return CalendarViewHolder(itemCalendarBinding)
    }

    override fun getItemCount(): Int {
        return listDay.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bindData(listDay[position])
        holder.setOnClickItem(context, position, listDate)
//        holder.setBackgroundCurrentDate(context, listDate)
    }

    public fun clear(){
        listDate.clear()
        listDay.clear()
        notifyDataSetChanged()
    }

    public fun setBackgroundCurrentDate(context: Context, listDate: MutableList<Date>, view : View) : Boolean{
        val calendar : Calendar = Calendar.getInstance()
        for (date : Date in listDate){
            if (calendar.time.date == date.date){
//                view.background = ContextCompat.getDrawable(context,R.drawable.bg_button_calendar)
                SpManager.getInstance(context).putString("calendar date", calendar.time.toString())
                return true
            }
        }
        return false
    }

}

