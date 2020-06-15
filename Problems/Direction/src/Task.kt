import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    when (scanner.nextInt()) {
        1 -> print("move up")
        2 -> print("move down")
        3 -> print("move left")
        4 -> print("move right")
        0 -> print("do not move")
        else -> print("error!")
    }
}