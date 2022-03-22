package br.senai.sp.jogodaveia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class vencedorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vencedor)

        val voltar = findViewById<ImageView>(R.id.voltar)

        voltar.setOnClickListener{ voltarHome()}

    }
    private fun voltarHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}