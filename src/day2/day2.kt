package day2

import Lib.readLines

/**
 * Day 2 of advent of code 2017.
 *
 * @author foresterre
 */
fun main(args: Array<String>) {

    val splitByRows = readLines("resources/day2/input.in")
    val spreadsheetAsStrings = splitByRows.map { i -> i.split("\t") }
    val spreadsheetAsInts = spreadsheetAsStrings.map { line -> line.map { value -> Integer.valueOf(value) } }

    // part 1
    println(checksum(spreadsheetAsInts))
}

fun checksum(spreadsheet: List<List<Int>>): Int {
    fun min(collection: Collection<Int>): Int = collection.min() as Int
    fun max(collection: Collection<Int>): Int = collection.max() as Int

    return spreadsheet.map { i -> max(i) - min(i) }.sum()
}