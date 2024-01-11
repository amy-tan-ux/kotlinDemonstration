package com.example.demo.model.forecast

import com.example.demo.model.UnitCodeValue
import java.time.format.DateTimeFormatter
data class Properties(
    var updated: DateTimeFormatter,
    var units: String,
    var forecastGenerator: String,
    var generatedAt: DateTimeFormatter,
    var updateTime: DateTimeFormatter,
    var validTimes: DateTimeFormatter,
    var elevation: UnitCodeValue,
    var periods: List<Periods>
)
