package edu.jmendezv.kotlin4javadevelopersreview._06_otrosaspectosimportantes

fun main() {
    val r = 1..10
    val impares = generateSequence(1) { it + 2 }
    println(impares.take(10).last())
    val s: String? = null
}