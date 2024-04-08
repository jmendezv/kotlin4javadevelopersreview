package edu.jmendezv.kotlin4javadevelopersreview._07_introconcurrencia

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println(Thread.currentThread().name)
        launch {
            println(Thread.currentThread().name)
            withContext(Dispatchers.Default) {
                println(Thread.currentThread().name)
                delay(1000)
                println("10 results found.")
            }
        }
        println(Thread.currentThread().name)
        println("Loading...")
    }
}