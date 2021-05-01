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
    /** Для генерации последующего Car Number */
    fun getNewCarNumber(): CarNumber {
        val a = "А111АА 116 RUS"
        val carNumbers = carNumbersRepository.findAll()
        if (carNumbers.isEmpty()) return save(CarNumber(number = a))

        val carNumber = carNumbers.last()

        val number = carNumber.number

        if (number == "Х999ХХ") {    //todo: проверить
            carNumber.number = a
            return save(carNumber)
        }

        var digits = carNumber.number.substring(1, 4)
        var char1 = carNumber.number.substring(0, 1)
        var char2 = carNumber.number.substring(4, 5)
        var char3 = carNumber.number.substring(5, 6)

        // проверяем цифры:
        if (digits != "999") {
            digits = (digits.toInt() + 1).toString()
            carNumber.number = char1 + digits + char2 + char3 + " " + Dictionary.REGION_116
            return save(carNumber)
        }

        // проверяем последнюю цифру:
        val letters = dictionary.letters.sorted()
        if (char3 != letters.last()) {
            for (i in letters.indices) {
                if (char3 == letters[i]) {
                    char3 = letters[i + 1]
                    carNumber.number = char1 + digits + char2 + char3 + " " + Dictionary.REGION_116
                    return save(carNumber)
                }
            }
        }

        //todo: проверяем предпоследнюю цифру
        //todo: проверяем первую цифру


        return save(carNumber)
    }

    /** Для генерации случайного Car Number */
    fun getRandomCarNumber(): CarNumber {

        val numberResult =
            dictionary.letters.random() + getRandomDigit() + dictionary.letters.random() + dictionary.letters.random() +
                    " " + Dictionary.REGION_116

        val carNumbers = carNumbersRepository.findAll()

        if (carNumbers.isEmpty()) {
            return save(CarNumber(number = numberResult))
        }

        val carNumber = carNumbers.last()
        carNumber.number = numberResult
        save(carNumber)

        return carNumber
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
