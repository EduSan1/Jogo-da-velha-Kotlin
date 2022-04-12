package br.senai.sp.jogodaveia

import android.widget.Button

fun verificarVencedor(marcador : Array<String>) : Boolean{
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

fun empate(button : Array<Button>) : Boolean{
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
fun resetarJogo(botoes : Array<Button>, marcador: Array<String>):String {
    var index=0
    while ( index <=8 ) {
        botoes[index].text = ""
        botoes[index].isEnabled = true
        marcador[index] = index.toString()
        index++

    }

    return "jogador"
}

