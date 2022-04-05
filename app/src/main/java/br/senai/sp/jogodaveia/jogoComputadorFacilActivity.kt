package br.senai.sp.jogodaveia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class jogoComputadorFacilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo_computador_facil)

        val intent: Intent = getIntent()
        val voltar = findViewById<ImageView>(R.id.voltar)

        voltar.setOnClickListener{ voltarHome()}

        val dificuldade = intent.getStringExtra("dificuldade")
        val texto = findViewById<TextView>(R.id.dificuldadeTxt)

        texto.text = dificuldade

        val btn1 = findViewById<Button>(R.id.botao1)
        val btn2 = findViewById<Button>(R.id.botao2)
        val btn3 = findViewById<Button>(R.id.botao3)
        val btn4 = findViewById<Button>(R.id.botao4)
        val btn5 = findViewById<Button>(R.id.botao5)
        val btn6 = findViewById<Button>(R.id.botao6)
        val btn7 = findViewById<Button>(R.id.botao7)
        val btn8 = findViewById<Button>(R.id.botao8)
        val btn9 = findViewById<Button>(R.id.botao9)

        val placarJogador = findViewById<TextView>(R.id.placarJogador)
        val placarComputador = findViewById<TextView>(R.id.placarComputador)
        val txtView: Array<TextView> = arrayOf(placarComputador,placarJogador)

        val botoes: Array<Button> = arrayOf(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9)
        val marcador: Array<String> = arrayOf("1","2","3","4","5","6","7","8","9")

        btn1.setOnClickListener {
            //preencher o botao com a opção do jogador
            btn1.text = "x"
            btn1.isEnabled = false
            marcador[0] = "jogador"
            //sortear jogada do computador
            sortearComputador(marcador,botoes,txtView)
        }
        btn2.setOnClickListener {
            //preencher o botao com a opção do jogador
            btn2.text = "x"
            btn2.isEnabled = false
            marcador[1] = "jogador"
            //sortear jogada do computador
            sortearComputador(marcador,botoes,txtView)
        }
        btn3.setOnClickListener {
            //preencher o botao com a opção do jogador
            btn3.text = "x"
            btn3.isEnabled = false
            marcador[2] = "jogador"
            //sortear jogada do computador
            sortearComputador(marcador,botoes,txtView)
        }
        btn4.setOnClickListener {
            //preencher o botao com a opção do jogador
            btn4.text = "x"
            btn4.isEnabled = false
            marcador[3] = "jogador"
            //sortear jogada do computador
            sortearComputador(marcador,botoes,txtView)
        }
        btn5.setOnClickListener {
            //preencher o botao com a opção do jogador
            btn5.text = "x"
            btn5.isEnabled = false
            marcador[4] = "jogador"
            //sortear jogada do computador
            sortearComputador(marcador,botoes,txtView)
        }
        btn6.setOnClickListener {
            //preencher o botao com a opção do jogador
            btn6.text = "x"
            btn6.isEnabled = false
            marcador[5] = "jogador"
            //sortear jogada do computador
            sortearComputador(marcador,botoes,txtView)
        }
        btn7.setOnClickListener {
            //preencher o botao com a opção do jogador
            btn7.text = "x"
            btn7.isEnabled = false
            marcador[6] = "jogador"
            //sortear jogada do computador
            sortearComputador(marcador,botoes,txtView)
        }
        btn8.setOnClickListener {
            //preencher o botao com a opção do jogador
            btn8.text = "x"
            btn8.isEnabled = false
            marcador[7] = "jogador"
            //sortear jogada do computador
            sortearComputador(marcador,botoes,txtView)
        }
        btn9.setOnClickListener {
            //preencher o botao com a opção do jogador
            btn9.text = "x"
            btn9.isEnabled = false
            marcador[8] = "jogador"
            //sortear jogada do computador
            sortearComputador(marcador,botoes,txtView)
        }

    }


    private fun sortearComputador(marcador: Array<String>, botoes: Array<Button>,txtView: Array<TextView>) {
       var index = 0;
        var botaoSorteado = 0;

        if (!verificarBotoes(botoes)) {
            while (index == 0) {

                botaoSorteado = Random.nextInt(0, 8)


                if (marcador[botaoSorteado] != "jogador" && marcador[botaoSorteado] != "computador") {
                    botoes[botaoSorteado].text = botaoSorteado.toString()
                    marcador[botaoSorteado] = "computador"
                    botoes[botaoSorteado].isEnabled = false
                    index++
                }

            }
        }


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



        } else if (verificarBotoes(botoes) == true) {
            resetarJogo(botoes,marcador,viewJogadores)
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
//        mudarCorBotao(viewJogadores)

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

    private fun verificarBotoes(button : Array<Button>) : Boolean{
        if (button[0].isEnabled == false &&
            button[1].isEnabled == false &&
            button[2].isEnabled == false &&
            button[3].isEnabled == false &&
            button[4].isEnabled == false &&
            button[5].isEnabled == false &&
            button[6].isEnabled == false &&
            button[7].isEnabled == false &&
            button[8].isEnabled == false ) {
            return  true
        }else {
            return false
        }
    }

    private fun voltarHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}