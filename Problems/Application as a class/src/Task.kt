class Application(val name: String) {

    fun run(arrayStr: Array<String>) {
        println(name)
        for (str in arrayStr) {
            println(str)
        }
    }
}