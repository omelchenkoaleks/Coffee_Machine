import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val number = scanner.nextInt()
    findCountTens(number)
}

fun findCountTens(num: Int) {
    val n = num / 10
    println(n % 10)
}