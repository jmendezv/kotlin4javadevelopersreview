package edu.jmendezv.kotlin4javadevelopersreview._06_otrosaspectosimportantes

data class Dispositivo(val id: Long, val nombre: String, var precio: Double)
fun main() {
    val d = Dispositivo(341345L, "Driver", 234.55)
    val (id, nombre, precio) = d
    println("$id $nombre $precio")
}