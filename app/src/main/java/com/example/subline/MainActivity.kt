package com.example.subline

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.view.ViewDebug.IntToString
import android.widget.Button
import android.widget.TextView
import android.widget.SeekBar
import android.widget.EditText


lateinit var text_node: TextView
lateinit var slider_node: SeekBar
lateinit var button_node: Button
lateinit var min_size_node: EditText
lateinit var max_size_node: EditText

var min_size: Int = 0
var max_size: Int = 10


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
        min_size_node = findViewById(R.id.minSize)
        max_size_node = findViewById(R.id.maxSize)

        min_size_node.setText(min_size.toString())
        max_size_node.setText(max_size.toString())

        slider_node.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                text_node.rotation = (progress - 25.0).toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        min_size_node.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                var _text: String = min_size_node.text.toString()

                if (_text == ""){
                    _text = "0"
                    min_size_node.setText("0")
                } else {
                    if (_text.length > max_size_node.text.toString().length){
                        var max_size_length: Int = max_size_node.text.toString().toInt()
                        var _limit_string: String = (max_size_length - 1).toString()

                        min_size_node.setText(_limit_string)
                        _text = _limit_string
                    }
                }

                min_size = _text.toInt()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
        max_size_node.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                var _text: String = max_size_node.text.toString()

                if (_text == ""){
                    _text = "0"
                    max_size_node.setText("0")
                }

                max_size = _text.toInt()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    public fun pressButton(_input : View){
        val _randi_number: Int = (min_size..max_size).random()
        text_node.text = "O numero aleatorio é: " + _randi_number.toString()
    }
    public fun sliderChange(_progress: Int){
        text_node.rotation = (_progress - 25).toFloat() * 2
    }

}
