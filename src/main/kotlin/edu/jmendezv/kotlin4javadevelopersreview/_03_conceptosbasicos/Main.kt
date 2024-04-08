package edu.jmendezv.kotlin4javadevelopersreview._03_conceptosbasicos

/**
 *
 * @author Pep
 * @param n
 * @return Boolean
* */
fun esPrimo(n: Int): Boolean {
    if (n < 2) return false
    var ret = true
    var i = 2
    loop@ while (i < n) {
        if (n % i == 0) {
            ret = false
            break@loop
        }
        i += 1
    }
    return ret
}

fun main() {
    for (i in 1..25)
        println("$i ${esPrimo(i)}")
}