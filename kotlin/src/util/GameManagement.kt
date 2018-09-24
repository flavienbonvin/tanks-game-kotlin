package util

import res.Constants

fun shootEnemy(){
    displayRemainingEnemies()

    val shootNbr = askUserToEnterAInt("Which tank you want to attack? (0 to ${Constants.GameConstants.enemyTanks.size-1}): ")

    println()

    if(shootNbr > Constants.GameConstants.nbrEnemies){
        println("The number you entered is too big!")
        shootEnemy()
    }

    if (Constants.GameConstants.enemyTanks[shootNbr].hp <= 0.0) {
        println("This tank is already destroyed! Stop being so persistent!")
        shootEnemy()
    } else if(shootNbr < Constants.GameConstants.enemyTanks.size && shootNbr >= 0){
        fireAtEnemy(shootNbr)
        gameMenu()
    } else {
        println("The number you entered is wrong!")
        shootEnemy()
    }
}

private fun fireAtEnemy(nbr: Int){
    println("Firing at the tank ${Constants.GameConstants.enemyTanks[nbr].name}!")

    val tankHp = Constants.GameConstants.enemyTanks[nbr].hp - 5

    if(tankHp <= 0){
        val destroyedTank = Constants.GameConstants.enemyTanks[nbr]
        Constants.GameConstants.enemyTanks[nbr].isAlive = false
        Constants.GameConstants.remainingTanks--

        println("You destroyed a tank! ${destroyedTank.name} from ${destroyedTank.country} has been defeated!")
        println("${Constants.GameConstants.remainingTanks} tanks remaining")
    }

    println()
    Constants.GameConstants.enemyTanks[nbr].hp = tankHp
}

fun printEnemiesTanks(){
    for(tank in Constants.GameConstants.enemyTanks){
        println(tank.toString())
    }
}

private fun displayRemainingEnemies(){

    println("Enemy tanks left: ")
    for((index, tank) in Constants.GameConstants.enemyTanks.withIndex()){
        if(tank.isAlive){
            println("$index Enemy tank: ${tank.name} from ${tank.country} has ${tank.hp}hp left")
        }
    }
    println()
}