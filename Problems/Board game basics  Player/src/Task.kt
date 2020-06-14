class Player(val id: Int, val name: String, val hp: Int = 100) {

    companion object {

        private var id: Int = 0

        fun create(name: String): Player {
            id++
            return Player(id, name)
        }
    }

}