package com.example.pinview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        impPinview()
    }

    private fun  impPinview(){

        val pin1 = findViewById<TextInputLayout>(R.id.input_1)
        val pin2 = findViewById<TextInputLayout>(R.id.input_2)
        val pin3 = findViewById<TextInputLayout>(R.id.input_3)
        val pin4 = findViewById<TextInputLayout>(R.id.input_4)
        val pin5 = findViewById<TextInputLayout>(R.id.input_5)
        val pin6 = findViewById<TextInputLayout>(R.id.input_6)


        pin1.editText?.doOnTextChanged{text, _, _, count ->

            if (count == 1){
                pin1.editText?.isEnabled = false
                pin2.editText?.isEnabled = true
                pin2.editText?.requestFocus()

                displayKeyboard(true, pin2.editText!!)

            }

        }

        pin2.editText?.doOnTextChanged{text, _, _, count ->

            if (count == 1){
                pin2.editText?.isEnabled = false
                pin3.editText?.isEnabled = true
                pin3.editText?.requestFocus()

                displayKeyboard(true, pin3.editText!!)
            }else{
                pin2.editText?.isEnabled = false
                pin1.editText?.isEnabled = true
                pin1.editText?.requestFocus()

                displayKeyboard(true, pin1.editText!!)
            }

        }

        pin3.editText?.doOnTextChanged{text, _, _, count ->

            if (count == 1){

                pin3.editText?.isEnabled = false
                pin4.editText?.isEnabled = true
                pin4.editText?.requestFocus()

                displayKeyboard(true, pin4.editText!!)

            }else{
                pin3.editText?.isEnabled = false
                pin2.editText?.isEnabled = true
                pin2.editText?.requestFocus()

                displayKeyboard(true, pin2.editText!!)
            }
        }

        pin4.editText?.doOnTextChanged{text, _, _, count ->

            if (count == 1){

                pin4.editText?.isEnabled = false
                pin5.editText?.isEnabled = true
                pin5.editText?.requestFocus()

                displayKeyboard(true, pin5.editText!!)
            }else{
                pin4.editText?.isEnabled = false
                pin3.editText?.isEnabled = true
                pin3.editText?.requestFocus()

                displayKeyboard(true, pin3.editText!!)
            }

        }

        pin5.editText?.doOnTextChanged{text, _, _, count ->

           if (count == 1){

               pin5.editText?.isEnabled = false
               pin6.editText?.isEnabled = true
               pin6.editText?.requestFocus()

               displayKeyboard(true, pin6.editText!!)

           }else{
               pin5.editText?.isEnabled = false
               pin4.editText?.isEnabled = true
               pin4.editText?.requestFocus()

               displayKeyboard(true, pin4.editText!!)
           }

        }

        pin6.editText?.doOnTextChanged{text, _, _, count ->

            if (count == 1){

                pin5.editText?.isEnabled = false
                pin5.editText?.requestFocus()
                pin6.editText?.isEnabled = true
                displayKeyboard(true, pin5.editText!!)

            }else{
                pin6.editText?.isEnabled = false
                pin5.editText?.isEnabled = true
                pin5.editText?.requestFocus()

                displayKeyboard(true, pin5.editText!!)
            }
        }
    }
    private fun displayKeyboard(display: Boolean, editText: EditText){

        if(display){
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        }else{
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(editText.getWindowToken(),0)
        }

    }
}
