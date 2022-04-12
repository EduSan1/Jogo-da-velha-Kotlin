package br.senai.sp.jogodaveia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class jogoComputadorFacilActivity : AppCompatActivity() {

    var placarJogadorInterno = 0
    var placarComputadorInterno = 0

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
        val placares: Array<TextView> = arrayOf(placarComputador,placarJogador)

        val botoes: Array<Button> = arrayOf(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9)
        val marcador: Array<String> = arrayOf("1","2","3","4","5","6","7","8","9")

        btn1.setOnClickListener {
            btn1.text = "x"
            btn1.isEnabled = false
            marcador[0] = "jogador"
            vencedor(marcador,placares,botoes,0)
            sortearComputador(marcador,botoes,placares)
        }
        btn2.setOnClickListener {
            btn2.text = "x"
            btn2.isEnabled = false
            marcador[1] = "jogador"
            vencedor(marcador,placares,botoes,1)
            sortearComputador(marcador,botoes,placares)
        }
        btn3.setOnClickListener {
            btn3.text = "x"
            btn3.isEnabled = false
            marcador[2] = "jogador"
            vencedor(marcador,placares,botoes,2)
            sortearComputador(marcador,botoes,placares)
        }
        btn4.setOnClickListener {
            btn4.text = "x"
            btn4.isEnabled = false
            marcador[3] = "jogador"
            vencedor(marcador,placares,botoes,3)
            sortearComputador(marcador,botoes,placares)
        }
        btn5.setOnClickListener {
            btn5.text = "x"
            btn5.isEnabled = false
            marcador[4] = "jogador"
            vencedor(marcador,placares,botoes,4)
            sortearComputador(marcador,botoes,placares)
        }
        btn6.setOnClickListener {
            btn6.text = "x"
            btn6.isEnabled = false
            marcador[5] = "jogador"
            vencedor(marcador,placares,botoes,5)
            sortearComputador(marcador,botoes,placares)
        }
        btn7.setOnClickListener {
            btn7.text = "x"
            btn7.isEnabled = false
            marcador[6] = "jogador"
            vencedor(marcador,placares,botoes,6)
            sortearComputador(marcador,botoes,placares)
        }
        btn8.setOnClickListener {
            btn8.text = "x"
            btn8.isEnabled = false
            marcador[7] = "jogador"
            vencedor(marcador,placares,botoes,7)
            sortearComputador(marcador,botoes,placares)
        }
        btn9.setOnClickListener {
            btn9.text = "x"
            btn9.isEnabled = false
            marcador[8] = "jogador"
            vencedor(marcador,placares,botoes,8)
            sortearComputador(marcador,botoes,placares)
        }

    }

    private fun vencedor(
        marcador: Array<String>,
        placares: Array<TextView>,
        botoes: Array<Button>,
        index : Int
    ) {
        if (verificarVencedor(marcador) == true) {
            var vencedorTexto = ""
            if (marcador[index] == "jogador"){
                placarJogadorInterno++
                placares[1].text = placarJogadorInterno.toString()
                resetarJogo(botoes,marcador)
                vencedorTexto = "Jogador"
            }else if (marcador[index] ==  "computador" ){
                placarComputadorInterno++
                placares[0].text = placarComputadorInterno.toString()
                resetarJogo(botoes,marcador)
                vencedorTexto = "Computador"
            }

            if (placarJogadorInterno == 3 || placarComputadorInterno == 3) {
                placarJogadorInterno = 0
                placarComputadorInterno = 0
                val intent = Intent(this, vencedorActivity::class.java)
                intent.putExtra("vencedor", vencedorTexto)
                startActivity(intent)
            }



        } else if (empate(botoes) == true) {
            resetarJogo(botoes,marcador)
        }
    }


    private fun sortearComputador(marcador: Array<String>, botoes: Array<Button>,placares: Array<TextView>) {
       var index = 0;
        var botaoSorteado = 0;

        if (!empate(botoes)) {
            while (index == 0) {

                botaoSorteado = Random.nextInt(0, 8)


                if (marcador[botaoSorteado] != "jogador" && marcador[botaoSorteado] != "computador") {
                    botoes[botaoSorteado].text = "o"
                    marcador[botaoSorteado] = "computador"
                    botoes[botaoSorteado].isEnabled = false
                    index++
                    vencedor(marcador,placares,botoes,botaoSorteado)
                }

            }
        }







    }


    private fun voltarHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}