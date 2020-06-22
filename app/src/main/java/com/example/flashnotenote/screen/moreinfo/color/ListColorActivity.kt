package com.example.flashnotenote.screen.moreinfo.color

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.flashnotenote.R
import com.example.flashnotenote.databinding.ActivityColorListBinding
import kotlinx.android.synthetic.main.activity_color_list.*

class ListColorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_list)
        toolbarColorList.title = "Color"
        setSupportActionBar(toolbarColorList)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val binding: ActivityColorListBinding = DataBindingUtil.setContentView(this, R.layout.activity_color_list)
        binding.listener = this
    }

    fun getColor(view : View){
        when(view.id) {
            R.id.textRed -> imageTickColorRed.visibility = View.VISIBLE
            R.id.textPurple -> imageTickColorPurple.visibility = View.VISIBLE
            R.id.textGreen -> imageTickColorGreen.visibility = View.VISIBLE
            R.id.textBlue -> imageTickColorBlue.visibility = View.VISIBLE
            R.id.textYellow -> imageTickColorYellow.visibility = View.VISIBLE
            R.id.textBrow -> imageTickColorBrow.visibility = View.VISIBLE
            R.id.textOrange -> imageTickColorOrange.visibility = View.VISIBLE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}