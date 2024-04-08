package edu.jmendezv.kotlin4javadevelopersreview._08_apendices._08_B_io

import java.io.BufferedReader
import kotlin.io.path.Path
import kotlin.io.path.bufferedReader
import kotlin.io.path.bufferedWriter

fun leeFichero(fileName: String): String {
    var ret: String = ""
    val bufferedReader: BufferedReader = Path(fileName).bufferedReader()
    bufferedReader.forEachLine {
        ret += it
    }
    bufferedReader.close()
    return ret
}

fun escribeFichero(fileName: String, text: String): Unit {
    val bufferedWriter = Path(fileName).bufferedWriter()
    bufferedWriter.write(text)
    bufferedWriter.close()
}
fun main(args: Array<String>) {
    escribeFichero("fichero1.txt", "Contenido del fichero1...")
    println(leeFichero("fichero1.txt"))
}