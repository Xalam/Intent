package com.example.intent_project

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

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

        val buttonDial = findViewById<Button>(R.id.btn_dial)
        buttonDial.setOnClickListener(this)

        val buttonResult = findViewById<Button>(R.id.btn_pindahhasil)
        buttonResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
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

            R.id.btn_dial -> {
                val phoneNumber = "081847384334"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_pindahhasil -> {
                val intentHasil = Intent(this@MainActivity, PindahHasilActivity::class.java)
                startActivityForResult(intentHasil, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (requestCode == PindahHasilActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(PindahHasilActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }
    }
}
