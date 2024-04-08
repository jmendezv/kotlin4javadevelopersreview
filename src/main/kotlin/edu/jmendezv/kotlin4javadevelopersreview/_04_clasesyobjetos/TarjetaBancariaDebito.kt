package edu.jmendezv.kotlin4javadevelopersreview._04_clasesyobjetos

class TarjetaBancariaDebito(titular: String, saldo: Double = 0.0) :
    TarjetaBancaria(titular, saldo) {
    override fun abona(abono: Double) {
        if (saldo >= abono) {
            saldo -= abono
        } else {
            throw IllegalArgumentException("Error: El saldo actual $saldo€ es insuficiente para abonar $abono€.")
        }
    }
}