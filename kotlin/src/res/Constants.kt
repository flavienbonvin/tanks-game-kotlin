package res

import obj.Tank

object Constants {
    object GameConstants {
        const val fileNameTankList = "src/res/tanksNames.txt"
        var nbrEnemies: Int = 0
        val enemyTanks: MutableList<Tank> = mutableListOf()
        var remainingTanks: Int = 0
    }
}