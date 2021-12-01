package day1

import java.io.File

private val input = File("./input.txt")
    .readLines()
    .map { it.toInt() }

//Assign sums
private val sums = mutableListOf<Int>()

input.forEachIndexed { index, measurement ->
    try {
        sums.add(measurement + input[index + 1] + input[index + 2])
    } catch (e: IndexOutOfBoundsException) {
        //PASS
    }
}

//Count sums larger than previous
private var countOfSumsLargerThanPrevious = 0

sums.forEachIndexed { index, measurement ->
    if (index == 0) return@forEachIndexed

    val previous = sums[index - 1]

    if (measurement > previous) {
        countOfSumsLargerThanPrevious++
    }
}

println(countOfSumsLargerThanPrevious)