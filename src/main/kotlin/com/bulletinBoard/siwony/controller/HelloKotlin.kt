package com.bulletinBoard.siwony.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/hello")
class HelloKotlin {

    @GetMapping()
    fun hello() : String{
        return "Hello Kotlin and SpringBoot!"
    }
}