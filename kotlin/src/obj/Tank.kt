package obj

data class Tank(val name: String, val country: String, var hp: Double, var isAlive: Boolean) {

    override fun toString(): String {
        return """
            Tank information:
            Name: $name, Country: $country, HP: $hp, Is alive: $isAlive

        """.trimIndent()
    }
}