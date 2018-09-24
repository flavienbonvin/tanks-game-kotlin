package main.kotlin.menu

import main.kotlin.game.initGame
import main.kotlin.game.printEnemiesTanks
import main.kotlin.game.shootEnemy
import main.kotlin.resources.REMAINING_TANKS
import kotlin.system.exitProcess

fun startMenu() {

    println(
        """
        Tank game!

        n - start a new game
        q - quit the game
    """.trimIndent()
    )
    print("Action: ")
    val action = readLine()!!

    println()

    when (action) {
        "n" -> initGame()
        "q" -> quitGame()
        else -> {
            println("\nYou need to enter a correct action")
            startMenu()
        }
    }
}

fun gameMenu() {
    //If there are no enemy left, the game is finished
    if (REMAINING_TANKS == 0) {
        displayWinningMenu()
    } else {
        displayGameMenu()
    }
}

private fun displayGameMenu() {
    println(
        """
        Actions available:
        a - attack enemy tank
        p - print all enemies tanks
        q - quit the game
    """.trimIndent()
    )

    print("Action: ")
    val action = readLine()!!

    println()

    when (action) {
        "a" -> shootEnemy()
        "p" -> {
            printEnemiesTanks()
            gameMenu()
        }
        "q" -> quitGame()
        else -> {
            println("\nYou need to enter a correct action")
            gameMenu()
        }
    }
}

private fun displayWinningMenu() {
    println(
        """
            You won! All enemies tanks has been defeated!

            n - start a new game
            q - quit the game
        """.trimIndent()
    )
    print("Action: ")
    val action = readLine()!!

    when (action) {
        "n" -> initGame()
        "q" -> quitGame()
        else -> {
            println("\nYou need to enter a correct action")
            startMenu()
        }
    }
}


private fun quitGame() {
    println("\nThank you for playing the game!")
    exitProcess(0)
}