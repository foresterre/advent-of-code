package day2

import Lib.readLines

/**
 * Day 2 of advent of code 2017.
 *
 * @author foresterre
 */
fun main(args: Array<String>) {

    val splitByRows = readLines("resources/day2/input.in")
    val spreadsheetAsStrings = splitByRows.map { it.split("\t") }
    val spreadsheetAsInts = spreadsheetAsStrings.map { it.map { Integer.valueOf(it) } }

    // part 1
    println(checksum(spreadsheetAsInts))

    // part 2
    println(evenlyDivisibleSum(spreadsheetAsInts))
}

fun checksum(spreadsheet: List<List<Int>>): Int {
    fun min(collection: Collection<Int>): Int = collection.min() as Int
    fun max(collection: Collection<Int>): Int = collection.max() as Int

    return spreadsheet.map { max(it) - min(it) }.sum()
}

fun evenlyDivisibleSum(spreadsheet: List<List<Int>>): Int {
    fun isEvenlyDivisible(pair: Pair<Int, Int>): Boolean = pair.first % pair.second == 0

    val uniques = spreadsheet.map { it.toSet() }
    val divisibleCombinations = uniques.map {
        val combo = combinations(it).first { pair ->
            pair.first != pair.second && isEvenlyDivisible(pair)
        }
        combo.first / combo.second
    }

    return divisibleCombinations.sum()
}

fun combinations(set: Set<Int>): List<Pair<Int, Int>> {
    return set.flatMap { i -> set.map { j -> Pair(i, j) } }
}


