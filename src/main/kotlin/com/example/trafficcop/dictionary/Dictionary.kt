package com.example.trafficcop.dictionary

import org.springframework.stereotype.Component

@Component
class Dictionary {

    val letters = listOf("А", "Е", "Т", "О", "Р", "Н", "У", "К", "Х", "С", "В", "М")

    companion object {
        const val REGION_116 = "116 RUS"
    }
}
