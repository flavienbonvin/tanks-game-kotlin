package util

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const
import obj.Tank
import res.Constants
import java.io.File

fun initGame() {
    println("Configuration of the game")

    val nbrEnemies = askUserToEnterAInt("Number of desired enemy tanks: ")

    println()

    createEnemiesTanks(nbrEnemies)
    configSummary()

}

private fun configSummary(){
    println("""
        Summary of the configuration:
        Number of enemies: ${Constants.GameConstants.nbrEnemies}
        Enemies information:
    """.trimIndent())
    printEnemiesTanks()

    print("Is this correct? (y/n): ")
    val userInput = readLine()!!.toString()

    println()

    when (userInput){
        "y" -> gameMenu()
        "n" -> initGame()
        else -> configSummary()
    }
}

private fun createEnemiesTanks(nbrEnemies: Int){
    Constants.GameConstants.nbrEnemies = nbrEnemies
    //Used to track the end of the game
    Constants.GameConstants.remainingTanks = nbrEnemies
    //Must empty existing enemies in case of error during the creation process
    Constants.GameConstants.enemyTanks.removeAll { true }

    for (i in 0 until nbrEnemies){
        val tankInfo = getRandomTankName()
        Constants.GameConstants.enemyTanks.add(Tank(tankInfo[0], tankInfo[1],10.0, true))
    }
}


private fun getRandomTankName(): Array<String>{
    val list = mutableListOf<String>()
    File(Constants.GameConstants.fileNameTankList).useLines { lines -> list.addAll(lines) }

    val randomElement = list[(0 until list.size).shuffled().last()]
    val tankName = randomElement.substringBefore(";")
    val tankCountry = randomElement.substringAfter(";")

    return arrayOf(tankName, tankCountry)
}