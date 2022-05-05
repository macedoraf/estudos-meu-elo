package br.com.estudos.lolzinho.entidades

import java.io.Serializable

//Estrutras da dados

// Texto = String ex. "Rafael"
// Inteiro = Int ex. 0, -12, 90000
// Decimal = Float ou Double 0.5, -55.9992
// Lista = Array [1, 2, 3, 4, 22]
// Verdairo ou Falso = Boolean


class Invocador(val nome: String, val capeaoMaisJogado: String, val elo: Elo) : Serializable


