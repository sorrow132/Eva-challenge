package com.yuresko.evachallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yuresko.evachallenge.R
import com.yuresko.evachallenge.databinding.ActivityMainBinding
import com.yuresko.evachallenge.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}