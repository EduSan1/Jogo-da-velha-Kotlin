package br.senai.sp.jogodaveia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class dificuldadeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dificuldade)

        val btnFacil = findViewById<Button>(R.id.btnFacil)
        val btnMedio = findViewById<Button>(R.id.btnMedio)
        val btnDificil = findViewById<Button>(R.id.btnDificil)
        val voltar = findViewById<ImageView>(R.id.voltar)

        voltar.setOnClickListener{ voltarHome()}

        btnFacil.setOnClickListener { jogoFacil() }
        btnMedio.setOnClickListener { jogoMedio() }
        btnDificil.setOnClickListener { jogoDificil() }


    }

    private fun voltarHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun jogoDificil() {
        val intent = Intent(this, jogoComputadorActivity::class.java)
        var dificuldade = "Dark Souls das Veia";
        intent.putExtra("dificuldade",dificuldade)
        startActivity(intent)

    }

    private fun jogoMedio() {
        val intent = Intent(this, jogoComputadorActivity::class.java)
        var dificuldade = "Médio";
        intent.putExtra("dificuldade",dificuldade)
        startActivity(intent)
    }

    private fun jogoFacil() {
        val intent = Intent(this, jogoComputadorActivity::class.java)
        var dificuldade = "Fácil";
        intent.putExtra("dificuldade",dificuldade)
        startActivity(intent)
    }
}