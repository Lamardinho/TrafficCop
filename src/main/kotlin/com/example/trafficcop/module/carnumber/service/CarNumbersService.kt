package com.example.trafficcop.module.carnumber.service

import com.example.trafficcop.dictionary.Dictionary
import com.example.trafficcop.model.carnumber.CarNumber
import com.example.trafficcop.module.carnumber.repository.CarNumbersRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CarNumbersService(
    private val dictionary: Dictionary,
    private val carNumbersRepository: CarNumbersRepository
) {
    /** Для генерации случайного Car Number */
    fun getRandomCarNumber(): String {
        val letter = dictionary.letters.random()
        val digit = getRandomDigit()
        val letters = dictionary.letters.random() + dictionary.letters.random()

        val carNumber = save(CarNumber(number = letter + digit + letters + " " + Dictionary.REGION_116))

        return carNumber.number
    }

    fun save(carNum: CarNumber): CarNumber {
        return carNumbersRepository.save(carNum)
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
