package edu.jmendezv.kotlin4javadevelopersreview._05_funcionesylambdas

class Incrementor: (Int) -> Int {
    override operator fun invoke(x: Int): Int = x + 1
}

val incrementor: (Int) -> Int = Incrementor()
val incrementor2 = Incrementor()
fun f(a: Int, b: Int, g: (Int, Int) -> Int): Int = g(a, b)
val f1 = fun(x: Int, y: Int): Int = x + y
val f2 = fun(x: Int, y: Int) = x + y
val sum1: Int.(Int) -> Int = { other -> this.plus(other) }
val sum2 = fun Int.(other: Int): Int = this + other

infix fun String.abrevia(n: Int): String = this.substring(0, n)

fun main() {
    val suma: (Int, Int) -> Int = { a, b -> a + b }
    println(f(1, 2, suma))
    val v = f(1, 2, { a, b -> a * b })
    val w = f(1, 2) { a, b -> a * b }
    println(v)
    println(w)
    1.sum1(2)
    1.sum2(2)
    println("Calimnero".abrevia(3))
    println("Calimnero" abrevia 3)
    println(incrementor(1))
    println(incrementor2(1))
}