package edu.jmendezv.kotlin4javadevelopersreview._06_otrosaspectosimportantes

data class Fraccion(var num: Int, var denom: Int) {
    override fun toString(): String = "$num / $denom"
}
operator fun Fraccion.times(other: Fraccion) =
    Fraccion(num * other.num, denom * other.denom)
fun main() {
    println(Fraccion(1, 2).times(Fraccion(1, 2)))
}