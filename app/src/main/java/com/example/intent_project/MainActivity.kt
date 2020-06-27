package com.example.intent_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {


    companion object {
        private const val REQUEST_CODE =100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPindah = findViewById<Button>(R.id.btn_pindah)
        buttonPindah.setOnClickListener(this)

        val buttonPindahData = findViewById<Button>(R.id.btn_pindahdata)
        buttonPindahData.setOnClickListener(this)

        val buttonPindahObject = findViewById<Button>(R.id.btn_pindahobject)
        buttonPindahObject.setOnClickListener(this)
    }

    override fun onClick(v: View){
        when(v.id) {
            R.id.btn_pindah -> {
                val pindahIntent = Intent(this@MainActivity, PindahActivity::class.java)
                startActivity(pindahIntent)
            }

            R.id.btn_pindahdata -> {
                val pindahData = Intent(this@MainActivity, PindahDataActivity::class.java)
                pindahData.putExtra("EXTRA_NAME", "Xalam Boy")
                pindahData.putExtra("EXTRA_AGE", 20)
                startActivity(pindahData)
            }

            R.id.btn_pindahobject -> {
                val person = Person(
                    "Xalam",
                    20,
                    "xalam@gmail.com",
                    "Yogyakarta"
                )

                val pindahObject = Intent(this@MainActivity, PindahObjectActivity::class.java)
                pindahObject.putExtra("EXTRA_PERSON", person)
                startActivity(pindahObject)
            }
        }
    }
}
