package com.example.demo.model.forecast

import com.example.demo.model.UnitCodeValue
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
import java.time.format.DateTimeFormatter

data class Properties(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var updated: DateTimeFormatter,
    var units: String,
    var forecastGenerator: String,
    var generatedAt: DateTimeFormatter,
    var updateTime: DateTimeFormatter,
    var validTimes: DateTimeFormatter,
    var elevation: UnitCodeValue
)
