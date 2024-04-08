package edu.jmendezv.kotlin4javadevelopersreview._06_otrosaspectosimportantes

fun main() {
    val m = mapOf(1 to "Primero", 2 to "Segundo", 3 to "Tercero", 4 to "Cuarto")
    m.forEach { k, v ->
        println("$k $v")
    }
}