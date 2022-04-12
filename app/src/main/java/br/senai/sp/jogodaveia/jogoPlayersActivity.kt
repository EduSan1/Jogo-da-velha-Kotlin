package br.senai.sp.jogodaveia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView



class jogoPlayersActivity : AppCompatActivity() {

    var vez = "jogador"
    var placarJogadorUmInterno = 0
    var placarJogadorDoisInterno = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo_players)

        val voltar = findViewById<ImageView>(R.id.voltar)
        voltar.setOnClickListener{voltarHome()}

        val placarJogadorUm = findViewById<TextView>(R.id.placarJogadorUm)
        val placarJogadorDois = findViewById<TextView>(R.id.placarJogadorDois)
        val viewJogadorUm = findViewById<Button>(R.id.viewJogadorUm)
        val viewJogadorDois = findViewById<Button>(R.id.viewJogadorDois)

        val btn1 = findViewById<Button>(R.id.botao1)
        val btn2 = findViewById<Button>(R.id.botao2)
        val btn3 = findViewById<Button>(R.id.botao3)
        val btn4 = findViewById<Button>(R.id.botao4)
        val btn5 = findViewById<Button>(R.id.botao5)
        val btn6 = findViewById<Button>(R.id.botao6)
        val btn7 = findViewById<Button>(R.id.botao7)
        val btn8 = findViewById<Button>(R.id.botao8)
        val btn9 = findViewById<Button>(R.id.botao9)

        val botoes: Array<Button> = arrayOf(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9)
        val marcador: Array<String> = arrayOf("1","2","3","4","5","6","7","8","9")
        val viewJogadores: Array<Button> = arrayOf(viewJogadorUm,viewJogadorDois)

        placarJogadorUmInterno = 0
        placarJogadorDoisInterno = 0
        mudarCorBotao(viewJogadores)
//        var index = 0

//        while (index<=8) {
//            botoes[index].setOnClickListener {
//                marcador[index] = vez
//                botoes[index].text = suaVez(marcador[index],botoes[index], viewJogadores)
//                vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes)
//                botoes[index].text = "teste"
//            }
//            index++
//        }

        btn1.setOnClickListener {
            marcador[0] = vez
            btn1.text = suaVez(marcador[0],btn1, viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes)
        }

        btn2.setOnClickListener{
            marcador[1] = vez
            btn2.text = suaVez(marcador[1],btn2, viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes)
        }

        btn3.setOnClickListener{
            marcador[2] = vez
            btn3.text = suaVez(marcador[2],btn3,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes)}

        btn4.setOnClickListener{
            marcador[3] = vez
            btn4.text = suaVez(marcador[3],btn4,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes)  }

        btn5.setOnClickListener{
            marcador[4] = vez
            btn5.text = suaVez(marcador[4],btn5, viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes)   }

        btn6.setOnClickListener{
            marcador[5] = vez
            btn6.text = suaVez(marcador[5],btn6,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes) }

        btn7.setOnClickListener{
            marcador[6] = vez
            btn7.text = suaVez(marcador[6],btn7,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes)   }

        btn8.setOnClickListener{
            marcador[7] = vez
            btn8.text = suaVez(marcador[7],btn8,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes)   }

        btn9.setOnClickListener{
            marcador[8] = vez
            btn9.text = suaVez(marcador[8],btn9,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes)  }

    }

    private fun vencedor(
        marcador: Array<String>,
        placarJogadorDois : TextView,
        placarJogadorUm : TextView,
        botoes: Array<Button>,
    ) {
        if (verificarVencedor(marcador) == true) {
            if (vez == "jogador2"){
                placarJogadorUmInterno++
                resetarJogo(botoes,marcador)
                placarJogadorUm.text = placarJogadorUmInterno.toString()
            }else if (vez ==  "jogador" ){
                placarJogadorDoisInterno++
                placarJogadorDois.text = placarJogadorDoisInterno.toString()
                resetarJogo(botoes,marcador)
            }

            if (placarJogadorUmInterno == 3 || placarJogadorDoisInterno == 3) {
                placarJogadorDoisInterno =0
                placarJogadorUmInterno = 0
                val intent = Intent(this, vencedorActivity::class.java)
                if (vez == "jogador")
                    intent.putExtra("vencedor", "Jogador 2")
                else
                    intent.putExtra("vencedor", "Jogador 1")

                startActivity(intent)
            }



        } else if (empate(botoes) == true) {
            resetarJogo(botoes,marcador)
        }
    }

    private fun suaVez(jogador : String, botao: Button, viewJogadores: Array<Button>): String {

        var marca = "";
        if (jogador=="jogador"){
            marca ="x"
            vez = "jogador2"

        }else if (jogador=="jogador2") {
            marca ="o"
            vez = "jogador"
        }
        mudarCorBotao(viewJogadores)
        botao.isEnabled = false

        return marca

    }

    private fun mudarCorBotao(viewJogadores: Array<Button>) {

        if (vez == "jogador") {
            viewJogadores[0].setBackgroundResource(R.drawable.background_blue)
            viewJogadores[1].setBackgroundResource(R.drawable.background_desabilitado)
        } else if (vez == "jogador2") {
            viewJogadores[1].setBackgroundResource(R.drawable.background_blue)
            viewJogadores[0].setBackgroundResource(R.drawable.background_desabilitado)
        }


    }

    private fun voltarHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}