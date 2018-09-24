package util

import res.ENEMY_TANKS
import res.NUMBER_ENEMIES
import res.REMAINING_TANKS

fun shootEnemy() {
    displayRemainingEnemies()

    val shootNbr = askUserToEnterAInt("Which tank you want to attack? (0 to ${ENEMY_TANKS.size - 1}): ")

    println()

    if (shootNbr > NUMBER_ENEMIES) {
        println("The number you entered is too big!")
        shootEnemy()
    }

    if (ENEMY_TANKS[shootNbr].hp <= 0.0) {
        println("This tank is already destroyed! Stop being so persistent!")
        shootEnemy()
    } else if (shootNbr < ENEMY_TANKS.size && shootNbr >= 0) {
        fireAtEnemy(shootNbr)
        gameMenu()
    } else {
        println("The number you entered is wrong!")
        shootEnemy()
    }
}

private fun fireAtEnemy(nbr: Int) {
    println("Firing at the tank ${ENEMY_TANKS[nbr].name}!")

    val tankHp = ENEMY_TANKS[nbr].hp - 5

    if (tankHp <= 0) {
        val destroyedTank = ENEMY_TANKS[nbr]
        ENEMY_TANKS[nbr].isAlive = false
        REMAINING_TANKS--

        println("You destroyed a tank! ${destroyedTank.name} from ${destroyedTank.country} has been defeated!")
        println("$REMAINING_TANKS tanks remaining")
    }

    println()
    ENEMY_TANKS[nbr].hp = tankHp
}

fun printEnemiesTanks() {
    for (tank in ENEMY_TANKS) {
        println(tank.toString())
    }
}

private fun displayRemainingEnemies() {

    println("Enemy tanks left: ")
    for ((index, tank) in ENEMY_TANKS.withIndex()) {
        if (tank.isAlive) {
            println("$index Enemy tank: ${tank.name} from ${tank.country} has ${tank.hp}hp left")
        }
    }
    println()
}