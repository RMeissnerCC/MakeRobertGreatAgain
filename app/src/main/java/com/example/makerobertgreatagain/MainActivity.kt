package com.example.makerobertgreatagain

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Float.max

class MainActivity : AppCompatActivity() {
    lateinit var mainHandler: Handler

    private val minimalFontsize = 10f
    private var ourFontsize = minimalFontsize
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainHandler = Handler(Looper.getMainLooper())
    }

    fun increaseSizeClick(view: View) {
        val text: TextView = findViewById(R.id.textView)
        ourFontsize += 1F
        text.textSize = ourFontsize
    }

    fun onSplashPageClick(view: View) {
        finish()
    }

    private val updateTextTask = object : Runnable {
        override fun run() {
            decreaseTextSize()
            mainHandler.postDelayed(this, 1000)
        }
    }


    fun decreaseTextSize() {
        val text: TextView = findViewById(R.id.textView)
        ourFontsize = max(ourFontsize - 1F, minimalFontsize)
        text.textSize = ourFontsize
    }

    override fun onResume() {
        super.onResume()
        mainHandler.post(updateTextTask)
    }


    fun resetTextSize(view: View) {
        val text: TextView = findViewById(R.id.textView)
        text.textSize = minimalFontsize
        ourFontsize = minimalFontsize
    }
}

