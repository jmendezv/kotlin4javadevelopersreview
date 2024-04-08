package edu.jmendezv.kotlin4javadevelopersreview._06_otrosaspectosimportantes

data class Protocolo(val id: Long, val nombre: String, var desc: String) {
    var version: Double = 0.0
}

fun main() {
    val p1 = Protocolo(12345L, "VNet 1.4", "Protocolo de red bidireccional")
    p1.version = 1.0
    val p2 = Protocolo(12345L, "VNet 1.4", "Protocolo de red bidireccional")
    p2.version = 2.0
    println(p1 == p2)
    println(p1 === p2)
}