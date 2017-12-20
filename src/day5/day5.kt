package day5

import Lib.readLines

/*
 * Day 5 of advent of code 2017.
 *
 * @author foresterre
 */
fun main(args: Array<String>) {

    val jumpInstructions = readLines("resources/day5/input.in")

    // part 1
    println(findExitOfMaze(jumpInstructions.map { it.toInt() }, fun(_: Int): Int = 1))

    // part 2
    fun incrementer(amount: Int): Int = if (amount >= 3) {
        -1
    } else {
        1
    }

    println(findExitOfMaze(jumpInstructions.map { it.toInt() }, ::incrementer))

}

fun findExitOfMaze(instructions: List<Int>, updateWith: (amount: Int) -> Int): Int {

    val buffer = instructions.toMutableList()

    var stepsTaken = 0
    var index = 0

    while (isInsideMaze(buffer, index)) {
        index = jmp(buffer, index, updateWith)
        stepsTaken += 1
    }

    return stepsTaken
}

fun isInsideMaze(instructions: MutableList<Int>, index: Int) = (index < instructions.size && index >= 0)

// returns the next location to process
fun jmp(instructions: MutableList<Int>, index: Int, updateWith: (amount: Int) -> Int): Int {
    val offset = instructions[index]
    instructions[index] += updateWith(offset)
    return index + offset
}

