package edu.jmendezv.kotlin4javadevelopersreview._07_introconcurrencia

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.*
/*
* Deferred values provide a convenient way to transfer/return a single value between coroutines.
* Channels provide a way to transfer a stream of values between coroutines.
* A Channel is conceptually very similar to BlockingQueue.
* One key difference is that instead of a blocking put operation it has a suspending send, and instead
* of a blocking take operation it has a suspending receive.
* Unlike a queue, a channel can be closed to indicate that no more elements are coming.
* On the receiver side it is convenient to use a regular for loop to receive elements from the channel.
* */
fun main() = runBlocking<Unit> {
    val channel = Channel<String>()
    launch {
        channel.send("A1")
        channel.send("A2")
        println("A done")
    }
    launch {
        channel.send("B1")
        println("B done")
    }
    launch {
        repeat(3) {
            val x = channel.receive()
            println(x)
        }
    }
}