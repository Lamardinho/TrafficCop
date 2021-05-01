package com.example.trafficcop.module.carnumber.service

import com.example.trafficcop.dictionary.Dictionary
import org.springframework.stereotype.Service
import java.util.*

@Service
class CarNumbersService(
    private val dictionary: Dictionary
) {
    fun getRandomCarNumber(): String {
        val letter = dictionary.letters.random()
        val digit = getRandomDigit()
        val letters = dictionary.letters.random() + dictionary.letters.random()

        return letter + digit + letters + " " + Dictionary.REGION_116
    }

    private fun getRandomDigit(): String {
        val min = 0
        val max = 999
        val number = min + Random().nextInt(max - min + 1)

        return when {
            number < 10 -> "00$number"
            number < 99 -> "0$number"
            else -> number.toString()
        }
    }
}
