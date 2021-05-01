package com.example.trafficcop

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("autotest")
internal class Test1 {

    @Test
    fun getFullNameIsCorrect() {
        val fullNumber = "A111БВ 116 RUS"

        val number = fullNumber.substring(0, 6)
        val digits = fullNumber.substring(1, 4)

        val char1 = fullNumber.substring(0, 1)
        val char2 = fullNumber.substring(4, 5)
        val char3 = fullNumber.substring(5, 6)

        println(number)
        println(digits)
        println(char1)
        println(char2)
        println(char3)
    }

    @Test
    fun dictionary() {
        val letters = listOf("А", "Е", "Т", "О", "Р", "Н", "У", "К", "Х", "С", "В", "М").sorted()
        //[А, В, Е, К, М, Н, О, Р, С, Т, У, Х]
        println(letters)
    }
}
