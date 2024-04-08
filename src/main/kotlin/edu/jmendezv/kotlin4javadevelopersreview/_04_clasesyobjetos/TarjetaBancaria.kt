package edu.jmendezv.kotlin4javadevelopersreview._04_clasesyobjetos

import java.lang.IllegalArgumentException
import kotlin.properties.Delegates

abstract class TarjetaBancaria(private val titular: String, saldo: Currency = 0.0) :
    Movimientos {

    init {
        if (saldo < 0) {
            throw IllegalArgumentException("Saldo inicial no puede ser negativo.")
        }
    }

    protected var saldo: Currency by Delegates.observable(saldo) { property, oldValue, newValue ->
        println("\t*** ${property.name} modificado de $oldValue a $newValue ***")
    }
    override fun ingresa(ingreso: Double) {
        if (ingreso < 0) throw IllegalArgumentException("Ingreso no puede ser negativo.")
        saldo += ingreso
    }

    override fun toString(): String {
        return "$titular $saldo€"
    }

}