package edu.jmendezv.kotlin4javadevelopersreview._06_otrosaspectosimportantes

import java.lang.RuntimeException

fun f() = 0
fun g(): Any = throw RuntimeException()
fun main() {
    val result: Result<Any> = runCatching {
        f()
    }
    println(result)
}