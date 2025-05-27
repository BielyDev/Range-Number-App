package com.example.subline

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.view.ViewDebug.IntToString
import android.widget.Button
import android.widget.TextView
import android.widget.SeekBar


lateinit var text_node: TextView
lateinit var slider_node: SeekBar
lateinit var button_node: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        text_node = findViewById(R.id.textResult)
        slider_node = findViewById(R.id.rotationValueX)

        slider_node.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                text_node.rotation = (progress - 25.0).toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    public fun pressButton(input : View){
        val _randi_number: Int = (1..10).random()
        text_node.text = "O numero aleatorio é: " + _randi_number.toString()
    }
    public fun sliderChange(_progress: Int){
        text_node.rotation = (_progress - 25).toFloat() * 2
    }

}
