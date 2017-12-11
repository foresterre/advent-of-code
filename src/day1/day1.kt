package day1

import Lib.read

/**
 * Day 1 of advent of code 2017.
 *
 * @author foresterre
 */
fun main(args: Array<String>) {

    val input = read("resources/day1/input.in")
    val intList = splitTextToInt(input)

    println(day1part1SolveNaive(intList))
    println(day1part1SolveFunctional(intList))
    println(day1part2SolveNaive(intList))
    println(day1part2SolveFunctional(intList))
}



fun splitTextToInt(inputText: String): List<Int> {
    return inputText.toCharArray().asList().map { c ->
        Integer.valueOf(c.toString())
    }
}

fun day1part1SolveNaive(inputDigits: List<Int>): Int {
    var sum = 0

    for (i in 1 until inputDigits.size) {
        val prev = inputDigits[i - 1]
        val current = inputDigits[i]

        if (prev == current) sum += current
    }

    if (inputDigits.last() == inputDigits.first()) sum += inputDigits.first()

    return sum
}

fun day1part1SolveFunctional(inputDigits: List<Int>): Int {
    val prevNextCombos = inputDigits.zip(inputDigits.drop(1).plus(inputDigits.first()))

    return prevNextCombos.filter { (i, j) -> i == j }.sumBy { it.first }
}


fun day1part2SolveNaive(inputDigits: List<Int>): Int {
    // assumes lists with even amount of digits as per exercise

    var sum = 0

    val forward = inputDigits.size/2

    for (i in 0 until inputDigits.size) {
        val halfwayIndex = (i + forward) % inputDigits.size
        val halfway = inputDigits[halfwayIndex]
        val current = inputDigits[i]

        if (halfway == current) sum += current

    }

    return sum
}

fun day1part2SolveFunctional(inputDigits: List<Int>): Int {
    val skip = fun (index: Int): Int = (index + (inputDigits.size / 2)) % inputDigits.size

    val halfNextCombos = inputDigits.zip(inputDigits.mapIndexed { index, i -> i to inputDigits[skip(index)] })

    return halfNextCombos.filter { (_, y) -> y.first == y.second }.sumBy { it.second.first }
}