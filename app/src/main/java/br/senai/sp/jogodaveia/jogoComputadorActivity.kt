package br.senai.sp.jogodaveia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class jogoComputadorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo_computador)

        val intent: Intent = getIntent()
        val voltar = findViewById<ImageView>(R.id.voltar)

        voltar.setOnClickListener{ voltarHome()}

        val dificuldade = intent.getStringExtra("dificuldade")
        val texto = findViewById<TextView>(R.id.dificuldadeTxt)

        texto.text = dificuldade




//        imcTextView.text = intent.getStringExtra("imc")
    }
    private fun voltarHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}