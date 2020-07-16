package com.example.flashnotenote.screen.moreinfo.color

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import com.example.flashnotenote.R
import com.example.flashnotenote.databinding.ActivityColorListBinding
import com.example.flashnotenote.utils.SpManager
import kotlinx.android.synthetic.main.activity_color_list.*

class ListColorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_list)
        setSupportActionBar(toolbarColorList)
        toolbarColorList.title = "Color"
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val binding: ActivityColorListBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_color_list)
        binding.listener = this
    }

    fun getColor(view : View){
        when(view.id) {
            R.id.textRed -> checkTickColor(imageTickColorRed, resources.getColor(R.color.color_red))
            R.id.textPurple -> checkTickColor(imageTickColorPurple, resources.getColor(R.color.color_purple))
            R.id.textGreen -> checkTickColor(imageTickColorGreen,  resources.getColor(R.color.color_green))
            R.id.textBlue -> checkTickColor(imageTickColorBlue,  resources.getColor(R.color.color_blue))
            R.id.textYellow -> checkTickColor(imageTickColorYellow,  resources.getColor(R.color.color_yellow))
            R.id.textBrow -> checkTickColor(imageTickColorBrow, resources.getColor(R.color.color_brown))
            R.id.textOrange -> checkTickColor(imageTickColorOrange, resources.getColor(R.color.color_orange))
        }
    }

    fun checkTickColor(image : AppCompatImageView, colorResource : Int) {
        if (image.visibility == View.VISIBLE) {
            image.visibility = View.GONE
        }else {
            image.visibility = View.VISIBLE
            SpManager.getInstance(applicationContext).putInt("COLOR", colorResource)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}