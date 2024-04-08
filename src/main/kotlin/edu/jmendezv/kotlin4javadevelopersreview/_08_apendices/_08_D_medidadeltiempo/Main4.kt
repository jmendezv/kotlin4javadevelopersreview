package edu.jmendezv.kotlin4javadevelopersreview._08_apendices._08_D_medidadeltiempo

import kotlin.time.measureTime
import kotlin.time.measureTimedValue

fun main() {
    /*
    * Medida de la duración de procesos.
    * */
    val timeTaken1 = measureTime {
        Thread.sleep(100)
    }
    println(timeTaken1) // e.g. 103 ms
    /*
    * Medida de la duración de procesos y retorno de valor.
    * */
    val (value, timeTaken2) = measureTimedValue {
        Thread.sleep(100)
        42
    }
    println(value)     // 42
    println(timeTaken2) // e.g. 103 ms
}