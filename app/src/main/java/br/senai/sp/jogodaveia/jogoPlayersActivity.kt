package br.senai.sp.jogodaveia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

var vez = "jogador2"
var placarJogadorUmInternoI = 0
var placarJogadorDoisInternoI = 0

class jogoPlayersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo_players)

        val voltar = findViewById<ImageView>(R.id.voltar)
        voltar.setOnClickListener{ voltarHome()}

        val placarJogadorUm = findViewById<TextView>(R.id.placarJogadorUm)
        val placarJogadorDois = findViewById<TextView>(R.id.placarJogadorDois)

        val viewJogadorUm = findViewById<Button>(R.id.viewJogadorUm)
        val viewJogadorDois = findViewById<Button>(R.id.viewJogadorDois)

        val viewJogadores: Array<Button> = arrayOf(viewJogadorUm,viewJogadorDois)


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

        var placarJogadorUmInterno = 0
        var placarJogadorDoisInterno = 0



        btn1.setOnClickListener {
            marcador[0] = vez
            btn1.text = suaVez(marcador[0],btn1, viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes, viewJogadores)
        }

        btn2.setOnClickListener{
            marcador[1] = quemJogou()
            btn2.text = suaVez(marcador[1],btn2, viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes, viewJogadores)
        }

        btn3.setOnClickListener{
            marcador[2] = quemJogou()
            btn3.text = suaVez(marcador[2],btn3,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes, viewJogadores)}

        btn4.setOnClickListener{
            marcador[3] = quemJogou()
            btn4.text = suaVez(marcador[3],btn4,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes, viewJogadores)  }

        btn5.setOnClickListener{
            marcador[4] = quemJogou()
            btn5.text = suaVez(marcador[4],btn5, viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes, viewJogadores)   }

        btn6.setOnClickListener{
            marcador[5] = quemJogou()
            btn6.text = suaVez(marcador[5],btn6,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes, viewJogadores) }

        btn7.setOnClickListener{
            marcador[6] = quemJogou()
            btn7.text = suaVez(marcador[6],btn7,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes, viewJogadores)   }

        btn8.setOnClickListener{
            marcador[7] = quemJogou()
            btn8.text = suaVez(marcador[7],btn8,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes, viewJogadores)   }

        btn9.setOnClickListener{
            marcador[8] = quemJogou()
            btn9.text = suaVez(marcador[8],btn9,viewJogadores)
            vencedor(marcador,placarJogadorDois,placarJogadorUm,botoes,viewJogadores)  }

    }

    private fun vencedor(
        marcador: Array<String>,
        placarJogadorDois : TextView,
        placarJogadorUm : TextView,
        botoes: Array<Button>,
        viewJogadores: Array<Button>
    ) {
        if (venceu(marcador) == true) {
            if (vez == "jogador1" ){
                placarJogadorUmInternoI++
                resetarJogo(botoes,marcador,viewJogadores)
                placarJogadorUm.text = placarJogadorUmInternoI.toString()
            }else if (vez == "jogador2" ){
                placarJogadorDoisInternoI++
                placarJogadorDois.text = placarJogadorDoisInternoI.toString()
                resetarJogo(botoes,marcador,viewJogadores)
            }

            if (placarJogadorUmInternoI == 3 || placarJogadorDoisInternoI == 3) {
                placarJogadorDoisInternoI =0
                placarJogadorUmInternoI = 0
                val intent = Intent(this, vencedorActivity::class.java)
                startActivity(intent)
            }



        }
    }

    private fun resetarJogo(botoes : Array<Button>, marcador: Array<String>, viewJogadores: Array<Button>) {
        var index=0
        while ( index <=8 ) {
            botoes[index].text = ""
            botoes[index].isEnabled = true
            marcador[index] = index.toString()
            index++

        }
        vez = "jogador1" +
                ""
        mudarCorBotao(viewJogadores)

    }

    private fun venceu(marcador : Array<String>) : Boolean{
        if (marcador[0] == marcador[1] && marcador[0] == marcador[2]) {
            return true
        }else if (marcador[3] == marcador[4] && marcador[3] == marcador[5]){
            return true
        }else if (marcador[6] == marcador[7] && marcador[6] == marcador[8]){
            return true
        }else if (marcador[0] == marcador[3] && marcador[0] == marcador[6]){
            return true
        }else if (marcador[1] == marcador[4] && marcador[1] == marcador[7]){
            return true
        }else if (marcador[2] == marcador[5] && marcador[2] == marcador[8]) {
            return true
        }else if (marcador[0] == marcador[4] && marcador[0] == marcador[8]){
            return true
        }else if (marcador[2] == marcador[4] && marcador[2] == marcador[6]){
            return true
        }else {
            return false
        }
    }




    private fun quemJogou(): String {
        return vez
    }

    private fun suaVez(jogador : String, botao: Button, viewJogadores: Array<Button>): String {

        var marca = "";
        if (jogador=="jogador1"){
            marca ="x"
            mudarCorBotao(viewJogadores)
            vez = "jogador2"

        }else if (jogador=="jogador2") {
            marca ="o"
            viewJogadores[0].setBackgroundResource(R.drawable.background_desabilitado)
            viewJogadores[1].setBackgroundResource(R.drawable.background_blue)
            mudarCorBotao(viewJogadores)
            vez = "jogador1"
        }
        botao.isEnabled = false

        return marca

    }

    private fun mudarCorBotao(viewJogadores: Array<Button>) {

        if (vez == "jogador1") {
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