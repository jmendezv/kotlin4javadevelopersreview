package edu.jmendezv.kotlin4javadevelopersreview._04_clasesyobjetos

import java.lang.IllegalArgumentException


class TarjetaBancariaCredito(val limiteCredito: LimiteCredito, titular: String, saldo: Double = 0.0) :
    TarjetaBancaria(titular, saldo) {
    override fun abona(abono: Double) {
        if (saldo + limiteCredito.limite >= abono) {
            saldo -= abono
        } else {
            throw IllegalArgumentException("Error: el saldo actual $saldo, es suficiente para abonar $abono€ porque excede el descubierto permitido de ${limiteCredito.limite}€")
        }
    }
}