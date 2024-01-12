package com.example.demo.model.forecast

import com.example.demo.model.UnitCodeValue
import com.fasterxml.jackson.annotation.JsonProperty

data class Periods(
    @JsonProperty("number") var number: Int,
    @JsonProperty("name") var name: String,
    @JsonProperty("startTime") var startTime: String,
    @JsonProperty("endTime") var endTime: String,
    @JsonProperty("isDayTime") var isDaytime: Boolean,
    @JsonProperty("temperature") var temperature: String,
    @JsonProperty("temperatureUnit") var temperatureUnit: String,
    @JsonProperty("temperatureTrend") var temperatureTrend: String?,
    @JsonProperty("probabilityOfPrecipitation") var probabilityOfPrecipitation: UnitCodeValue,
    @JsonProperty("dewpoint") var dewpoint: UnitCodeValue,
    @JsonProperty("relativeHumidity") var relativeHumidity: UnitCodeValue,
    @JsonProperty("windSpeed") var windSpeed: String,
    @JsonProperty("windDirection") var windDirection: String,
    @JsonProperty("icon") var icon: String,
    @JsonProperty("shortForecast") var shortForecast: String,
    @JsonProperty("detailedForecast") var detailedForecast: String


)
