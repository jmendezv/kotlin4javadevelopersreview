package edu.jmendezv.kotlin4javadevelopersreview._04_clasesyobjetos

import java.lang.IllegalArgumentException

fun main() {
    val tbd: TarjetaBancaria = TarjetaBancariaDebito("Juan", 1000.0)
    val tbcg: TarjetaBancaria = TarjetaBancariaCredito(LimiteCredito.LimiteCreditoGolden(),"Carlos", 1000.0)
    val tbcp: TarjetaBancaria = TarjetaBancariaCredito(LimiteCredito.LimiteCreditoPlatinum(),"Ana", 1000.0)
    println(tbd)
    println(tbcg)
    println(tbcp)
    tbd.ingresa(100.0)
    tbcg.ingresa(100.0)
    tbcp.ingresa(100.0)
    println(tbd)
    println(tbcg)
    println(tbcp)
    tbd.abona(1000.0)
    tbcg.abona(1000.0)
    tbcp.abona(1000.0)
    println(tbd)
    println(tbcg)
    println(tbcp)
    try {
        tbd.abona(150.0)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    try {
        tbcg.abona(4000.0)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    try {
        tbcp.abona(4000.0)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    println(tbd)
    println(tbcg)
    println(tbcp)
}