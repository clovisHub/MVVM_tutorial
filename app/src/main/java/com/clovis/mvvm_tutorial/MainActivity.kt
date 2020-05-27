package com.clovis.mvvm_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clovis.mvvm_tutorial.models.repository.FirstRepository
import com.clovis.mvvm_tutorial.views.FirstActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirstActivity.startFirstActivity(this)
    }
}
