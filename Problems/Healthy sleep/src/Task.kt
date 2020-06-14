import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val needSleep = scanner.nextInt()
    val sleepMax = scanner.nextInt()
    val sleep = scanner.nextInt()

    if (sleep in needSleep..sleepMax) {
        print("Normal")
    } else if (sleep < needSleep) {
        print("Deficiency")
    } else if (sleep > sleepMax) {
        print("Excess")
    }
}