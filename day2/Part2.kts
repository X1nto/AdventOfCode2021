import java.io.File

private val input = File("./input.txt")
    .readLines()

private var horizontalPosition = 0
private var depth = 0
private var aim = 0

input.forEach {
    val command = it.substringBefore(' ')
    val x = it.substringAfter(' ').toInt()
    when (command) {
        "forward" -> {
            horizontalPosition += x
            depth += aim * x
        }
        "up" -> aim -= x
        "down" -> aim += x
    }
}

println(horizontalPosition * depth)