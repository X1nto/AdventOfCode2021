import java.io.File

private val input = File("./input.txt")
    .readLines()

val length = input[0].length

val columns = IntArray(length) { 0 }

//Get columns
for (column in input) {
    column.forEachIndexed { index, char ->
        if (char == '0') {
            columns[index]--
        } else {
            columns[index]++
        }
    }
}

fun getRate(getOnePredicate: (Int) -> Boolean) {
    columns.map {
        if (getOnePredicate) {
            '1'
        } else {
            '0'
        }
    }.joinToString("").toInt(2)
}

println(
    getRate { it > 0 } * //Gamma rate
    getRate { it <= 0 }  //Epsilon rate
)