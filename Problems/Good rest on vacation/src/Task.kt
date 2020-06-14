import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val durationInDays = scanner.nextInt()
    val totalFoodCostPerDay = scanner.nextInt()
    val oneWayFlightCost = scanner.nextInt()
    val costOfOneNightInAHotel = scanner.nextInt()

    val result = totalCostOfTravel(durationInDays,
            totalFoodCostPerDay,
            oneWayFlightCost,
            costOfOneNightInAHotel)

    print(result)
}

fun totalCostOfNightsAtTheHotel(duration: Int, costOneNight: Int): Int {
    return duration * costOneNight - costOneNight
}

fun totalCostOfTravel(durationInDays: Int,
                      totalFoodCostPerDay: Int,
                      oneWayFlightCost: Int,
                      costOfOneNightInAHotel: Int): Int =
        (durationInDays * totalFoodCostPerDay
                + (oneWayFlightCost * 2)
                + totalCostOfNightsAtTheHotel(durationInDays, costOfOneNightInAHotel))
