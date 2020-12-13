package com.aaqanddev.aboutmeapplication2

import android.content.Context
import android.databinding.DataBindingUtil
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.aaqanddev.aboutmeapplication2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var nickTextView: TextView
    private lateinit var doneButton: Button
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aaron Quaday")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //set data in layout with myName var
        binding.myName = myName

        //set binding variables for views
        doneButton = binding.buttonDone
        editText = binding.editTextNickname
        nickTextView = binding.textViewNickname

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
                
                binding.apply{
                    //setting value of nickname in myName object to content of ET
                    myName?.nickname = nick
                    invalidateAll()
                }
                updateViews()
            } else {
              Toast.makeText(this, getString(R.string.missing_nick_prompt), Toast.LENGTH_SHORT).show()
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
//        nickTextView.visibility = when (nickTextView.visibility){
//            View.VISIBLE -> View.GONE
//            else -> View.VISIBLE
//        }
//        editText.visibility = when (editText.visibility){
//            View.VISIBLE -> View.GONE
//            else -> View.VISIBLE
//        }
//        doneButton.visibility = when (doneButton.visibility){
//            View.VISIBLE -> View.GONE
//            else -> View.VISIBLE
//        }

        //Kotlinized form, accesssing views via binding directly, with apply
        binding.apply{
            textViewNickname.visibility = when (textViewNickname.visibility){
                View.VISIBLE -> View.GONE
                else -> View.VISIBLE
            }
            editTextNickname.visibility = when (editTextNickname.visibility){
                View.VISIBLE -> View.GONE
                else -> View.VISIBLE
            }
            buttonDone.visibility = when (buttonDone.visibility){
                View.VISIBLE -> View.GONE
                else -> View.VISIBLE
            }

        }
    }
}