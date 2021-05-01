package com.example.trafficcop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class TrafficCopApplication

@Bean
fun locale(): Locale {
    return Locale.getDefault()
}

fun main(args: Array<String>) {
    runApplication<TrafficCopApplication>(*args)
    println(appStarted())
}

fun appStarted(): String {
    return """  
 ▄▄▄·  ▄▄▄· ▄▄▄·    .▄▄ · ▄▄▄▄▄ ▄▄▄· ▄▄▄  ▄▄▄▄▄▄▄▄ .·▄▄▄▄  
▐█ ▀█ ▐█ ▄█▐█ ▄█    ▐█ ▀. •██  ▐█ ▀█ ▀▄ █·•██  ▀▄.▀·██▪ ██ 
▄█▀▀█  ██▀· ██▀·    ▄▀▀▀█▄ ▐█.▪▄█▀▀█ ▐▀▀▄  ▐█.▪▐▀▀▪▄▐█· ▐█▌
▐█ ▪▐▌▐█▪·•▐█▪·•    ▐█▄▪▐█ ▐█▌·▐█ ▪▐▌▐█•█▌ ▐█▌·▐█▄▄▌██. ██ 
 ▀  ▀ .▀   .▀        ▀▀▀▀  ▀▀▀  ▀  ▀ .▀  ▀ ▀▀▀  ▀▀▀ ▀▀▀▀▀•                                                                                         
"""
}
