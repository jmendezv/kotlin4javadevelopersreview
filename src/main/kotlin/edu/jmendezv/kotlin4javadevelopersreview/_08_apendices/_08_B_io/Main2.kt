package edu.jmendezv.kotlin4javadevelopersreview._08_apendices._08_B_io


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import java.lang.reflect.Type
import kotlin.io.path.Path
import kotlin.io.path.bufferedReader
import kotlin.io.path.bufferedWriter


class Tutorial(
    val title: String,
    val author: String,
    val students: Int,
    val stars: Int,
    val price: Double,
    val categories: List<String>
) {
    override fun toString(): String {
        return "Category [title: ${this.title}, author: ${this.author}, categories: ${this.categories}, stars: ${stars}, price: ${price}]"
    }
}

val tutsList: List<Tutorial> = listOf(
    Tutorial(
        "kotlin",
        "jose",
        1234,
        3,
        211.20,
        listOf("programacion orientada a objetos", "programacion funcional")
    ),
    Tutorial(
        "mysql",
        "juan",
        2315,
        5,
        198.77,
        listOf("instalacion bds", "bases de datos relacionales", "acceso tablas"),
    ),
    Tutorial(
        "java",
        "eva",
        3434,
        4,
        199.20,
        listOf("programacion orientada a objetos")
    ),
    Tutorial(
        "html",
        "mariana",
        5674,
        4,
        89.98,
        listOf("diseño web", "lenguaje de marcas")
    ),
);

fun writeJson(fileName: String, prettyPrinting: Boolean = true): Unit {

    val gson = Gson()

    if (prettyPrinting) {
        val gsonPretty = GsonBuilder().setPrettyPrinting().create()
        val jsonTutsListPretty: String = gsonPretty.toJson(tutsList)
        File(fileName).writeText(jsonTutsListPretty)
    } else {
        val jsonTutsList: String = gson.toJson(tutsList)
        File(fileName).writeText(jsonTutsList)
    }
}

fun <T> readJson(fileName: String): List<Tutorial> {
    val jsonFile: File = File(fileName)
    val jsonString: String = jsonFile.readText()
    val gson: Gson = Gson()
    val tutorialListType: Type = object : TypeToken<ArrayList<T?>?>() {}.type
    return gson.fromJson<ArrayList<Tutorial>?>(jsonString, tutorialListType)
}

fun readFile(fileName: String): String {
    var ret: String = ""

    val bufferedReader = Path(fileName).bufferedReader()
    bufferedReader.lines().forEach { line ->
        ret += line
    }
    bufferedReader.close()

    return ret
}

fun writeFile(fileName: String, text: String): Unit {
    val bufferedWriter = Path(fileName).bufferedWriter()
    bufferedWriter.write(text)
    bufferedWriter.close()
}

fun writeSequenceToFile(fileName: String, seq: Sequence<Int>): Unit {
    val bufferedWriter = Path(fileName).bufferedWriter()
    seq.forEach {
        bufferedWriter.write(it.toString() + "\n")
    }
    bufferedWriter.close()
}

fun main(args: Array<String>) {
    /*
    writeJson("tutoriales1.json")
    println(readFile("tutoriales1.json"))
    writeSequenceToFile("ingresos.txt", generateSequence {
        Random.nextInt(0, Int.MAX_VALUE)
    }.take(100000))
    writeSequenceToFile("gastos.txt", generateSequence {
        Random.nextInt(0, Int.MAX_VALUE)
    }.take(100000))
     */
    println(readJson<Tutorial>("tutoriales1.json"))
}