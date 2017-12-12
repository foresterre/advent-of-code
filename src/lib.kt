import java.io.File

/**
 * A small amount of functions used by several Advent of Code solutions.
 */
object Lib {
    fun read(path: String): String {
        val reader = File(path).bufferedReader()

        return reader.use { it.readText() }
    }

    fun readLines(path: String): List<String> {
        val reader = File(path).bufferedReader()

        return reader.useLines { it.toList() }
    }
}