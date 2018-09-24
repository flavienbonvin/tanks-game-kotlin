package util

import java.lang.Exception
import java.lang.NumberFormatException

fun askUserToEnterAInt (message: String): Int {
    var number: Int
    do {
        number = userInputInt(message)
    } while (number == -1)

    return number
}

private fun userInputInt (message: String): Int{

    print(message)

    var userInputConverted = -1

    try {
        val userInputStr = readLine()!!
        userInputConverted  = userInputStr.toInt()
    } catch (e: NumberFormatException){
        println("You did not entered a number!")
    } catch (e: Exception){
        println("Unhandled error")
        println(e.printStackTrace())
    }

    return userInputConverted
}