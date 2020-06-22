package com.example.flashnotenote.screen.moreinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.flashnotenote.R
import com.example.flashnotenote.databinding.ActivityMoreInfoBinding
import com.example.flashnotenote.screen.moreinfo.color.ListColorActivity
import kotlinx.android.synthetic.main.activity_more_info.*

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