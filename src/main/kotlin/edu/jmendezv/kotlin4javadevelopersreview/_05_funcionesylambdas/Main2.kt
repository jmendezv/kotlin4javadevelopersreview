package edu.jmendezv.kotlin4javadevelopersreview._05_funcionesylambdas

import java.lang.IllegalArgumentException
import kotlin.math.pow
import kotlin.math.sqrt

typealias EQU_SEGUNDO_GRADO = (Int, Int, Int) -> Pair<Fraccion<Double>, Fraccion<Double>>
data class Fraccion<T>(val numerador: T, val denominador: T) {
    init {
        assert(denominador != 0) {
            throw IllegalArgumentException("Denominador no puede ser 0")
        }
    }
    override fun toString(): String = "[$numerador/$denominador]"
}
class EquSegundoGrado : EQU_SEGUNDO_GRADO {
    override fun invoke(a: Int, b: Int, c: Int): Pair<Fraccion<Double>, Fraccion<Double>> {
        val raiz = sqrt(b.toDouble().pow(2.0) - 4 * a * c)
        val first = Fraccion(-b + raiz, 2.0 * a)
        val second = Fraccion(-b - raiz, 2.0 * a)
        return Pair(first, second)
    }
}
fun main() {
    val equSegundoGrado = EquSegundoGrado()
    // 6x^2 - 5x + 1 = 0
    println(equSegundoGrado(6, -5, 1))
}