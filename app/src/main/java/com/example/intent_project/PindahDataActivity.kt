package com.example.intent_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PindahDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_data)

        val tv_namaData = findViewById<TextView>(R.id.tv_namadata)
        val tv_umurData = findViewById<TextView>(R.id.tv_umurdata)

        val nama: String? = intent.getStringExtra("EXTRA_NAME")
        val umur:Int = intent.getIntExtra("EXTRA_AGE", 0)

        tv_namaData.setText("Nama : " + nama)
        tv_umurData.setText("Umur : " +umur.toString())

    }
}
