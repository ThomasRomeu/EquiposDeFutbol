package com.example.clase5equipodefutbol

data class Equipo(

    val id: Int,
    val name: String,
    val campeonatos: Int,
    val pais: tipoPais,
    val url: String,
    val apodo: String
)

enum class tipoPais{
    ARGENTINA, ESPAÑA, INGLATERRA, BRASIL, ALEMANIA, FRANCIA, ITALIA
}