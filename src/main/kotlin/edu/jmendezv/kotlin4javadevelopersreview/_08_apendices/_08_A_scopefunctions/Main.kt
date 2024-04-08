package edu.jmendezv.kotlin4javadevelopersreview._08_apendices._08_A_scopefunctions

import kotlin.random.Random

data class Elemento(val id: Long, var nombre: String = "", var estable: Boolean = true)

fun main() {
    // Método run() sin context object. Retorna la última expresión de la lambda. No es necesaria la orden 'return'.
    val c = run {
        println("En run()")
        println(Elemento(2456L, "Plata"))
        -1
    }
    println(c) // -1
    val obj = object { var x: Int = 0; var y: Int = 0; override fun toString(): String = "$x : $y" }
    println(obj) // 0 : 0
    // La función with() recibe como argumento el objeto de contexto. Se utiliza para modificarlo.
    with(obj) {
        x = 3
        y = 2
    }
    println(obj) // 3 : 2
    // La función let() retorna la última expresión de la lambda.
    val ret2 = obj.let {
        it.y - it.x
    }
    println(ret2) // -1
    // La función apply() retorna el objeto del contexto. Se suele usar para configurarlo.
    val elem = Elemento(1234L).apply {
        nombre = "Litium"
    }
    println(elem) // Elemento(id=1234, nombre=Litium, estable=true)
    // La función also() retorna el objeto del contexto.
    val n = elem.also {
        println(it) // Elemento(id=1234, nombre=Litium, estable=true)
        it.nombre = "aluminium"
        it.estable = false
    }
    println(n) // Elemento(id=1234, nombre=aluminium, estable=false)

    val numero = Random.nextInt(100)

    // El objeto esta disponible en la expresión lambda como 'it'
    val parONulo = numero.takeIf { it % 2 == 0 }
    val imparONulo = numero.takeUnless { it % 2 == 0 }
    println("par: $parONulo, impart: $imparONulo")

}