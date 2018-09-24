package main.kotlin.game

import main.kotlin.menu.askUserToEnterAInt
import main.kotlin.menu.gameMenu
import main.kotlin.resources.ENEMY_TANKS
import main.kotlin.resources.FILENAME_TANK_LIST
import main.kotlin.resources.NUMBER_ENEMIES
import main.kotlin.resources.REMAINING_TANKS
import java.io.File

fun initGame() {
    println("Configuration of the game")

    val nbrEnemies = askUserToEnterAInt("Number of desired enemy tanks: ")

    println()

    createEnemiesTanks(nbrEnemies)
    configSummary()

}

private fun configSummary() {
    println(
        """
        Summary of the configuration:
        Number of enemies: $NUMBER_ENEMIES
        Enemies information:
    """.trimIndent()
    )
    printEnemiesTanks()

    print("Is this correct? (y/n): ")
    val userInput = readLine()!!.toString()

    println()

    when (userInput) {
        "y" -> gameMenu()
        "n" -> initGame()
        else -> configSummary()
    }
}

private fun createEnemiesTanks(nbrEnemies: Int) {
    NUMBER_ENEMIES = nbrEnemies
    //Used to track the end of the game
    REMAINING_TANKS = nbrEnemies
    //Must empty existing enemies in case of error during the creation process
    ENEMY_TANKS.removeAll { true }

    for (i in 0 until nbrEnemies) {
        val tankInfo = getRandomTankName()
        ENEMY_TANKS.add(Tank(tankInfo.first, tankInfo.second, 10.0, true))
    }
}


private fun getRandomTankName(): Pair<String, String> {
    val list = File(FILENAME_TANK_LIST).useLines { lines -> lines.toMutableList() }

    val randomElement = list.shuffled().last()
    val tankName = randomElement.substringBefore(";")
    val tankCountry = randomElement.substringAfter(";")

    return Pair(tankName, tankCountry)
}