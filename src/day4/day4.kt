package day4

import Lib.readLines

/*
 * Day 4 of advent of code 2017.
 *
 * @author foresterre
 */
fun main(args: Array<String>) {

    val passphrases = readLines("resources/day4/input.in")

    // part 1
    println(phrasesWithOnlyUniqueWords(passphrases))

    // part 2
    println(amountOfPhrasesWithNoAnagrams(passphrases))
}

fun phrasesWithOnlyUniqueWords(passphrases: List<String>): Int {
    return passphrases
            .map { it.split(" ") }
            .filter { it.distinct().size == it.size }
            .size
}

fun amountOfPhrasesWithNoAnagrams(phrases: List<String>): Int {
    return phrases.map { it.split(" ") }
            .filter { phrase ->
                phrase.map { word ->
                    word.toCharArray().sorted()
                }.distinct().size == phrase.size
            }.size
}
