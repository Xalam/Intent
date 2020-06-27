package com.example.intent_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PindahObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_object)

        val tv_object = findViewById<TextView>(R.id.tv_dataobject)

        val person = intent.getParcelableExtra<Person>("EXTRA_PERSON")

        val text = "Nama : ${person?.name.toString()},\nEmail : ${person?.email},\nUmur : ${person?.age},\nLokasi : ${person?.city}"

        tv_object.setText(text)
    }
}
