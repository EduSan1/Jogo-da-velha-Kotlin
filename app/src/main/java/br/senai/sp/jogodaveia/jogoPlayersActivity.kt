package br.senai.sp.jogodaveia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class jogoPlayersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo_players)

        val voltar = findViewById<ImageView>(R.id.voltar)
        voltar.setOnClickListener{ voltarHome()}

        val btn1 = findViewById<Button>(R.id.botao1)
        val btn2 = findViewById<Button>(R.id.botao2)
        val btn3 = findViewById<Button>(R.id.botao3)
        val btn4 = findViewById<Button>(R.id.botao4)
        val btn5 = findViewById<Button>(R.id.botao5)
        val btn6 = findViewById<Button>(R.id.botao6)
        val btn7 = findViewById<Button>(R.id.botao7)
        val btn8 = findViewById<Button>(R.id.botao8)
        val btn9 = findViewById<Button>(R.id.botao9)
        val marcador: Array<String> = arrayOf("teste","teste","teste","teste","teste","teste","teste","teste","teste")


        btn1.setOnClickListener {
            marcador[0] = quemJogou()
            suaVez(btn1)
            btn1.text = "${marcador[0]}"
        }
        btn2.setOnClickListener{
            marcador[1] = quemJogou()
            suaVez(btn2)

            btn2.text = "${marcador[1]}"
        }
        btn3.setOnClickListener{
            marcador[2] = quemJogou()
            suaVez(btn3)

            btn3.text = "${marcador[2]}"
        }
        btn4.setOnClickListener{
            marcador[3] = quemJogou()
            suaVez(btn4)

            btn4.text = "${marcador[3]}"
        }
        btn5.setOnClickListener{
            marcador[4] = quemJogou()
            suaVez(btn5)

            btn5.text = "${marcador[4]}"
        }
        btn6.setOnClickListener{
            marcador[5] = quemJogou()
            suaVez(btn6)

            btn6.text = "${marcador[5]}"
        }
        btn7.setOnClickListener{
            marcador[6] = quemJogou()
            suaVez(btn7)

            btn7.text = "${marcador[6]}"
        }
        btn8.setOnClickListener{
            marcador[7] = quemJogou()
            suaVez(btn8)
            btn8.text = "${marcador[7]}"
        }
        btn9.setOnClickListener{

            marcador[8] = quemJogou()
            suaVez(btn9)
            btn9.text = "${marcador[8]}"
        }




    }



    var vez = "jogador1"

    private fun quemJogou(): String {
        return vez
    }

    private fun suaVez(botao:Button) {
            var idBotao = ""
        if (vez=="jogador1"){
            botao.text ="x"
            vez = "jogador2"
             idBotao = "${botao.id}j1"

        }else if (vez=="jogador2") {
            botao.text ="o"
            vez = "jogador1"
             idBotao = "${botao.id}j2"
        }
        botao.isEnabled = false
    }

    private fun voltarHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}