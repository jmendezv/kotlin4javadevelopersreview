package edu.jmendezv.kotlin4javadevelopersreview._07_introconcurrencia

import kotlin.system.*
import kotlinx.coroutines.*
import kotlin.RuntimeException

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            println(getWeatherReport())
            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async {
        getForecast()
    }
    val temperature = async {
        try {
            getTemperature()
        } catch (e: AssertionError) {
            println("Caught exception $e")
            "{ No temperature found }"
        }
    }

    delay(200)
    temperature.cancel()

    if (temperature.isActive)
        "${forecast.await()} ${temperature.await()}"
    else
        "${forecast.await()}"
}

suspend fun getForecast(): String {
    delay(1500)
    // throw RuntimeException("No forecast available.")
    return ("Sunny")
}

suspend fun getTemperature(): String {
    delay(500)
    // throw AssertionError("Temperature is invalid")
    return ("30\u00b0C")
}