package com.example.demo.model.forecast

import com.example.demo.model.UnitCodeValue
import java.time.format.DateTimeFormatter
data class Periods(
    var number: Int,
    var name: String,
    var startTime: DateTimeFormatter,
    var endTime: DateTimeFormatter,
    var isDaytime: Boolean,
    var temperature: Long,
    var temperatureUnit: String,
    var temperatureTrend: String?,
    var probabilityOfPrecipitation: UnitCodeValue,
    var dewpoint: UnitCodeValue,
    var relativeHumidity: UnitCodeValue,
    var windSpeed: String,
    var windDirection: String,
    var icon: String,
    var shortForecast: String,
    var detailedForecast: String


)
