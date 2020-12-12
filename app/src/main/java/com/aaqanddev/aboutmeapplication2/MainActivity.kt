package com.aaqanddev.aboutmeapplication2

import android.content.Context
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var nickTextView: TextView
    private lateinit var doneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doneButton = findViewById<Button>(R.id.button_done)
        editText = findViewById<EditText>(R.id.editText_nickname)
        nickTextView = findViewById(R.id.textView_nickname)

//        doneButton.setOnClickListener {
//
//            val nick = editText.text.toString()
//            if (nick!=""){
//                updateViewsOnDone(nick)
//            }
//        }
//        nickTextView.setOnClickListener {
//            updateViewsOnNickTV()
//        }
        doneButton.setOnClickListener {
            val nick = editText.text.toString()
            if (nick!=""){
                nickTextView.text = nick
                updateViews()
            }
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
        nickTextView.setOnClickListener {
            updateViews()
            editText.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, 0)
        }
    }

//    private fun updateViewsOnDone(nickname: String){
//        nickTextView.text = nickname
//        nickTextView.visibility = View.VISIBLE
//        editText.visibility = View.GONE
//        doneButton.visibility = View.GONE
//    }
//
//    private fun updateViewsOnNickTV(){
//        nickTextView.visibility = View.GONE
//        editText.visibility = View.VISIBLE
//        doneButton.visibility = View.VISIBLE
//    }

    private fun updateViews(){
        nickTextView.visibility = when (nickTextView.visibility){
            View.VISIBLE -> View.GONE
            else -> View.VISIBLE
        }
        editText.visibility = when (editText.visibility){
            View.VISIBLE -> View.GONE
            else -> View.VISIBLE
        }
        doneButton.visibility = when (doneButton.visibility){
            View.VISIBLE -> View.GONE
            else -> View.VISIBLE
        }
    }
}