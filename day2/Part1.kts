import java.io.File

private val input = File("./input.txt")
    .readLines()

var horizontalPosition = 0
var depth = 0

input.forEach {
    val command = it.substringBefore(' ')
    val x = it.substringAfter(' ').toInt()
    when (command) {
        "forward" -> horizontalPosition += x
        "up" -> depth -= x
        "down" -> depth += x
    }
}

println(horizontalPosition * depth)