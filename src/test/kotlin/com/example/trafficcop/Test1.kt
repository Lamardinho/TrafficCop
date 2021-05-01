package com.example.trafficcop

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("autotest")
internal class Test1 {
    @Test
    fun getFullNameIsCorrect() {
        println()
    }
}