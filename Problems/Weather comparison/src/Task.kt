class City(val name: String) {
    var degrees: Int = 0

    fun isDefault(temp: Int): Boolean {
        return temp < -92 || temp > 57
    }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    setDefaultTemp(firstCity, secondCity, thirdCity)

    val coldestCity = comparingTempCity(firstCity, secondCity, thirdCity)

    print(coldestCity)
}

fun setDefaultTemp(fCity: City, sCity: City, tCity: City) {
    val defF = fCity.isDefault(fCity.degrees)
    val defS = sCity.isDefault(sCity.degrees)
    val defT = tCity.isDefault(tCity.degrees)

    if (defF) fCity.degrees = 30
    if (defS) sCity.degrees = 5
    if (defT) tCity.degrees = 20
}

fun comparingTempCity(fCity: City, sCity: City, tCity: City): String {
    return (if (fCity.degrees < sCity.degrees && fCity.degrees < tCity.degrees) {
        fCity.name
    } else if (sCity.degrees < fCity.degrees && sCity.degrees < tCity.degrees) {
        sCity.name
    } else if (tCity.degrees < fCity.degrees && tCity.degrees < sCity.degrees) {
        tCity.name
    } else {
        "neither"
    }).toString()
}