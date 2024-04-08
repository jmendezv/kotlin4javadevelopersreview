package edu.jmendezv.kotlin4javadevelopersreview._03_conceptosbasicos

val holaMundo: String by lazy {
    println("En bloque lazy!")
    "Hola Mundo."
}

fun main() {
    println(holaMundo)
    println(holaMundo)
}