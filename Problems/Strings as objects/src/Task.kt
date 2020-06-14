import kotlin.Int as KotlinInt

val input = readLine()!!

fun main() {
    if (input.isEmpty()) {
        println(" ")
    } else {
        when {
            input.first() == 's' -> {
                checkS()
            }
            input.first() == 'i' -> {
                val n = input.drop(1).toInt() + 1
                println(n)
            }
            else -> {
                println(input)
            }
        }
    }


}

fun checkS() {
    if (input.first() == 's') {
        val s = input.drop(1).reversed()
        println(s)
    }
}