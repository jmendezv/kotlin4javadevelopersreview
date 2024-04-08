package edu.jmendezv.kotlin4javadevelopersreview._06_otrosaspectosimportantes

fun main() {
    val l = listOf(1, 2, 3, 4, 5, 4)
    l.filter {
        it % 2 == 0
    }.map {
        it * it
    }.forEach {
        print(it)
    }
}