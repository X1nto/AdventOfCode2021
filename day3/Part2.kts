import java.io.File

private val input = File("./input.txt")
    .readLines()

println(getRating(false) *
        getRating(true))

fun getRating(
    shouldInvert: Boolean
): Int {
    var mutInput = input
    for (i in 0 until input[0].length) {
        mutInput = mutInput.filterBits(i, shouldInvert)

        if (mutInput.size == 1) {
            break
        }
    }
    return mutInput[0].toInt(2)
}

fun List<String>.filterBits(
    index: Int,
    shouldInvert: Boolean
): List<String> {
    var correctNumber =
        if (count { it[index] == '1' } >= size / 2f) {
            '1'
        } else {
            '0'
        }

    if (shouldInvert) {
        if (correctNumber == '0') {
            correctNumber = '1'
        } else {
            correctNumber = '0'
        }
    }

    return filter { it[index] == correctNumber }
}