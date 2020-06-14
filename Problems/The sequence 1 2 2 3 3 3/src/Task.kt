
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val numberOfIterations = scanner.nextInt()
    var amount = 1
    val numArray = mutableListOf<Int>()

    while (numberOfIterations >= amount) {

        repeat(amount) {
            numArray += amount
        }
        amount++
    }

    val result = numArray.take(numberOfIterations)

    for (num in result) print("$num ")
}