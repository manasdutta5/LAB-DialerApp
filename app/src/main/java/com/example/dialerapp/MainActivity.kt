package com.example.dialerapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

// STEPS
//  for more info use https://developer.android.com/guide/components/intents-filters
// 1. design app
//2. add exp4j in gradle
//3. update manifest file
//4. Intents-   1. internal  2. external
//5. kotlin code

class MainActivity : AppCompatActivity() {

    private lateinit var zero: TextView
    private lateinit var one: TextView
    private lateinit var two: TextView
    private lateinit var three: TextView
    private lateinit var four: TextView
    private lateinit var five: TextView
    private lateinit var six: TextView
    private lateinit var seven: TextView
    private lateinit var eight: TextView
    private lateinit var nine: TextView
    private lateinit var star: TextView
    private lateinit var hash: TextView
    private lateinit var contact: TextView
    private lateinit var clear: Button
    private lateinit var saveBtn: Button
    private lateinit var callBtn: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        star = findViewById(R.id.asterisk)
        hash = findViewById(R.id.hash)
        contact = findViewById(R.id.contact)
        clear = findViewById(R.id.clear)
        saveBtn = findViewById(R.id.save)
        callBtn = findViewById(R.id.call)

        zero.setOnClickListener {
            pressButton("0", true)
        }
        one.setOnClickListener {
            pressButton("1", true)
        }
        two.setOnClickListener {
            pressButton("2", true)
        }
        three.setOnClickListener {
            pressButton("3", true)
        }
        four.setOnClickListener {
            pressButton("4", true)
        }
        five.setOnClickListener {
            pressButton("5", true)
        }
        six.setOnClickListener {
            pressButton("6", true)
        }
        seven.setOnClickListener {
            pressButton("7", true)
        }
        eight.setOnClickListener {
            pressButton("8", true)
        }
        nine.setOnClickListener {
            pressButton("9", true)
        }
        star.setOnClickListener {
            pressButton("*", true)
        }
        hash.setOnClickListener {
            pressButton("#", true)
        }

        clear.setOnClickListener {
            contact.text = ""
        }

        callBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL,Uri.parse("tel:" + "${contact.text}"))
            startActivity(intent)
        }

        saveBtn.setOnClickListener {
            val intent = Intent(
                ContactsContract.Intents.SHOW_OR_CREATE_CONTACT,
                Uri.parse("tel:" + contact.text))
            intent.putExtra(ContactsContract.Intents.EXTRA_FORCE_CREATE, true)//returns intent object, stores extra info
            startActivity(intent)
        }
    }

    fun pressButton(string: String,clear: Boolean){
        if(!clear){
            contact.text= ""
        }
        else {
            contact.append(string)
        }
    }
}