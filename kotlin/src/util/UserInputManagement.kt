package util

import java.lang.Exception
import java.lang.NumberFormatException

fun askUserToEnterAInt(message: String): Int {
    var number: Int?
    do {
        number = userInputInt(message)
    } while (number == null)

    return number
}

private fun userInputInt(message: String): Int? {
    print(message)
    return try {
        val userInputStr = readLine()!!
        userInputStr.toInt()
    } catch (e: NumberFormatException){
        println("You did not entered a number!")
        null
    } catch (e: Exception) {
        println("Unhandled error")
        println(e.printStackTrace())
        null
    }


    /*
    print(message)

    var userInputConverted = -1

    try {
        val userInputStr = readLine()!!
        userInputConverted = userInputStr.toInt()
    } catch (e: NumberFormatException) {
        println("You did not entered a number!")
    } catch (e: Exception) {
        println("Unhandled error")
        println(e.printStackTrace())
    }

    return userInputConverted
     */
}