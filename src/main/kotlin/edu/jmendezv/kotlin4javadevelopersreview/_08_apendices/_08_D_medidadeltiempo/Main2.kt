package edu.jmendezv.kotlin4javadevelopersreview._08_apendices._08_D_medidadeltiempo

import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

fun main() {
    /*
    * Con los objetos Duration, se pueden hacer operaciones aritméticas basicas.
    * */
    val fiveSeconds: Duration = 5.seconds
    val thirtySeconds: Duration = 30.seconds

    println(fiveSeconds + thirtySeconds)
// 35s
    println(thirtySeconds - fiveSeconds)
// 25s
    println(fiveSeconds * 2)
// 10s
    println(thirtySeconds / 2)
// 15s
    println(thirtySeconds / fiveSeconds)
// 6.0
    println(-thirtySeconds)
// -30s
    println((-thirtySeconds).absoluteValue)
// 30s
    /*
    * La función toString() permite pasar de una unidad a otra
    * */
    println(5887.milliseconds.toString(DurationUnit.SECONDS, 2))
    /*
    * La función toIsoString() permite obtener una representación compatible con la norma ISO-8601
    * */
    println(86420.seconds.toIsoString()) // PT24H0M20S
}