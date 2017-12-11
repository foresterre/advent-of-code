import java.io.File

/**
 * A small amount of functions used by several Advent of Code solutions.
 */
object Lib {
    fun read(path: String): String {
        val reader = File(path).bufferedReader()

        return reader.use { it.readText() }
    }
}