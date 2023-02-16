package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificaçao = findViewById<TextView>(R.id.textview_Classificaçao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        val classificçao = if (result < 18.5f) {
            "Abaixo do Peso"
        } else if (result in 18.5f..24.9f) {
            "Normal"
        } else if (result in 25f..29.9f) {
            "Sobrepeso"
        } else if (result in 30f..39.9f) {
            "Obesidade"
        } else {
            "Obesidade grave"
        }
        tvClassificaçao.text = getString(R.string.messageclassificaçao,classificçao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()

        return super.onOptionsItemSelected(item)

    }
}