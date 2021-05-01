package com.example.trafficcop.rest

import com.example.trafficcop.module.carnumber.service.CarNumbersService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/number")
class CarNumbersController(
    private val carNumbersService: CarNumbersService
) {
    /** Для генерации случайного Car Number */
    @GetMapping("/random")
    fun getRandom(): String {
        val carNumber = carNumbersService.getRandomCarNumber().number

        println(carNumber)
        return carNumber
    }

    @GetMapping("/next")
    fun getNext(): String {
        val carNumber = carNumbersService.getNewCarNumber().number

        println(carNumber)
        return carNumber
    }
}
