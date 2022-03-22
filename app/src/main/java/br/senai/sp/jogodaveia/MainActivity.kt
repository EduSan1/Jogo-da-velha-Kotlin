package br.senai.sp.jogodaveia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnJogadorVsJogador = findViewById<Button>(R.id.btnJogadorVsJogador)
        val btnComputadorVsJogador = findViewById<Button>(R.id.btnComputadorVsJogador)

        btnJogadorVsJogador.setOnClickListener{mudarTelaJogador()}
        btnComputadorVsJogador.setOnClickListener{selecionarDificuldadeActivity()}

    }

    private fun selecionarDificuldadeActivity() {
        val intent1 = Intent(this, dificuldadeActivity::class.java)
        startActivity(intent1)
    }

    private fun mudarTelaJogador() {
        val intent2 = Intent(this, jogoPlayersActivity::class.java)
        startActivity(intent2)
    }
}