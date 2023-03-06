package com.example.makerobertgreatagain

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun increaseSizeClick(view: View?) {
        val text: TextView = findViewById(R.id.textView)
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, (text.textSize*1.01).toFloat())
    }

    fun onSplashPageClick(view: View?) {
        finish()
    }

    fun resetTextSize(view: View?) {
        val text: TextView = findViewById(R.id.textView)
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
    }
}
