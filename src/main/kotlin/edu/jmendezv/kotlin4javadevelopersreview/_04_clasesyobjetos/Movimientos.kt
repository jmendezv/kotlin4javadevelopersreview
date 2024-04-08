package edu.jmendezv.kotlin4javadevelopersreview._04_clasesyobjetos

typealias Currency = Double

interface Movimientos {
    fun ingresa(ingreso: Currency): Unit
    fun abona(abono: Currency): Unit
}