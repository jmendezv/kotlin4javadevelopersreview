package edu.jmendezv.kotlin4javadevelopersreview._08_apendices._08_D_medidadeltiempo

import kotlin.time.TimeSource

fun main() {
    /*
    * Para marcar un momento específico usamos la interfaz TimeSource y la función markNow()
    * para crear un TimeMark.
    * */
    val timeSource = TimeSource.Monotonic
    val mark1 = timeSource.markNow()
    Thread.sleep(500) // Sleep 0.5 seconds.
    val mark2 = timeSource.markNow()

    println(mark1)
    println(mark2)
    println(mark2 - mark1)

    println(mark2 > mark1) // This is true, as mark2 was captured later than mark1.
// true
}