package day1

import java.io.File

private val input = File("./input.txt")
    .readLines()
    .map { it.toInt() }

//Count measurements larger than previous
private var countOfMeasurementsLargerThanPrevious = 0

input.forEachIndexed { index, measurement ->
    if (index == 0) return@forEachIndexed

    val previous = input[index - 1]

    if (measurement > previous) {
        countOfMeasurementsLargerThanPrevious++
    }
}

println(countOfMeasurementsLargerThanPrevious)