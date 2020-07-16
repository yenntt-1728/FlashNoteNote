package com.example.flashnotenote.screen.moreinfo

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.flashnotenote.R
import com.example.flashnotenote.databinding.ActivityMoreInfoBinding
import com.example.flashnotenote.screen.moreinfo.color.ListColorActivity
import com.example.flashnotenote.utils.SpManager
import kotlinx.android.synthetic.main.activity_more_info.*
import java.util.*


class MoreInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)
        toolBarMoreInfo.title = "Detail"
        setSupportActionBar(toolBarMoreInfo)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val binding : ActivityMoreInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_more_info)
        binding.listener = this
        textSelectTime.setOnClickListener {
            val mcurrentTime: Calendar = Calendar.getInstance()
            val hour: Int = mcurrentTime.get(Calendar.HOUR_OF_DAY)
            val minute: Int = mcurrentTime.get(Calendar.MINUTE)
            val mTimePicker: TimePickerDialog
            mTimePicker = TimePickerDialog(this,
                OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                    SpManager.getInstance(applicationContext).putString("time",
                        selectedHour.toString() + ":" + selectedMinute.toString())
                }, hour, minute, true
            ) //Yes 24 hour time

            mTimePicker.setTitle("Select Time")
            mTimePicker.show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun goToListColor(){
        val intent = Intent(this, ListColorActivity::class.java)
        startActivity(intent)
    }
}