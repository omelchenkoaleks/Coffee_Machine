import java.util.*

enum class Country(private val country: String, private val currency: String) {
    GERMANY("Germany", "Euro"),
    MALI("Mali", "CFA franc"),
    DOMINICA("Dominica", "Eastern Caribbean dollar"),
    CANADA("Canada", "Canadian dollar"),
    SPAIN("Spain", "Euro"),
    AUSTRALIA("Australia", "Australian dollar"),
    BRAZIL("Brazil", "Brazilian real"),
    SENEGAL("Senegal", "CFA franc"),
    FRANCE("France", "Euro"),
    GRENADA("Grenada", "Eastern Caribbean dollar"),
    KIRIBATI("Kiribati", "Australian dollar");

    fun getCurrencyCountry() = currency

    companion object {
        fun getCountry(c: String): String {
            when (c) {
                GERMANY.country -> {
                    return GERMANY.getCurrencyCountry()
                }
                MALI.country -> {
                    return MALI.getCurrencyCountry()
                }
                DOMINICA.country -> {
                    return DOMINICA.getCurrencyCountry()
                }
                CANADA.country -> {
                    return CANADA.getCurrencyCountry()
                }
                SPAIN.country -> {
                    return SPAIN.getCurrencyCountry()
                }
                AUSTRALIA.country -> {
                    return AUSTRALIA.getCurrencyCountry()
                }
                BRAZIL.country -> {
                    return BRAZIL.getCurrencyCountry()
                }
                SENEGAL.country -> {
                    return SENEGAL.getCurrencyCountry()
                }
                FRANCE.country -> {
                    return FRANCE.getCurrencyCountry()
                }
                GRENADA.country -> {
                    return GRENADA.getCurrencyCountry()
                }
                KIRIBATI.country -> {
                    return KIRIBATI.getCurrencyCountry()
                }
                else -> {
                    return "Such a country is not listed"
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)

    val countryOne = input.next().trim()
    val countryTwo = input.next().trim()

    val countryCurrencyX = Country.getCountry(countryOne).toUpperCase()
    val countryCurrencyY = Country.getCountry(countryTwo).toUpperCase()

    println(countryCurrencyX == countryCurrencyY)
}

