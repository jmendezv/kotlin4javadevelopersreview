package edu.jmendezv.kotlin4javadevelopersreview._07_introconcurrencia

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking {

    val channel = Channel<Int>()
    launch {
        for (x in 1..5) channel.send(x * x)
        channel.close() // we're done sending
    }
    // here we print received values using `for` loop (until the channel is closed)
    for (y in channel) println(y)
    println("Done!")

}