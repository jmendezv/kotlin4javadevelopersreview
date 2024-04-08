package edu.jmendezv.kotlin4javadevelopersreview._06_otrosaspectosimportantes

enum class TipoResepresentacion {
    SIMBOLICA, EXACTA
}

@Target(AnnotationTarget.CLASS)
annotation class Representacion(val tipoRepresentacion: TipoResepresentacion)


@Representacion(TipoResepresentacion.EXACTA)
data class Quebrado(val numerador: Int, val denominador: Int) {
    var tipoRepresentacion: TipoResepresentacion

    init {
        val clazze: Class<Quebrado> = Quebrado::class.java
        val representacion: Representacion = clazze.getAnnotation(Representacion::class.java)
        tipoRepresentacion = representacion.tipoRepresentacion
    }

    override fun toString(): String = when (tipoRepresentacion) {
        TipoResepresentacion.SIMBOLICA -> "$numerador/$denominador"
        TipoResepresentacion.EXACTA -> "${numerador.toDouble() / denominador}"
    }
}

fun main() {
    val f: Quebrado = Quebrado(3, 4)
    println(f)
}