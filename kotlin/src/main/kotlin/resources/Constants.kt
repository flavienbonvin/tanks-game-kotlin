package main.kotlin.resources

import main.kotlin.game.Tank

const val FILENAME_TANK_LIST = "src/resources/tanksNames.txt"
var NUMBER_ENEMIES: Int = 0
val ENEMY_TANKS: MutableList<Tank> = mutableListOf()
var REMAINING_TANKS: Int = 0