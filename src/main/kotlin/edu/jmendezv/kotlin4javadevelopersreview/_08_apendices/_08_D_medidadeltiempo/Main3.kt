package edu.jmendezv.kotlin4javadevelopersreview._08_apendices._08_D_medidadeltiempo

import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.microseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit


fun main() {
    /*
    * Conversión y comparación de unidades
    * */
    val thirtyMinutes: Duration = 30.minutes
    println(thirtyMinutes.inWholeSeconds)
// 1800
    println(270.seconds.toDouble(DurationUnit.MINUTES))
// 4.5
    val halfHour: Duration = 0.5.hours
    println(thirtyMinutes == halfHour)
// true
    println(3000.microseconds < 25000.nanoseconds)
// false
    println(thirtyMinutes.toComponents { hours, minutes, _, _ -> "${hours}h:${minutes}m" })
// 0h:30m
}