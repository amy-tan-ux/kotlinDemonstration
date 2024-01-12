package com.example.demo.model.forecast

import com.example.demo.model.UnitCodeValue
import com.fasterxml.jackson.annotation.JsonProperty

data class Properties(
    @JsonProperty("updated") var updated: String,
    @JsonProperty("units") var units: String,
    @JsonProperty("forecastGenerator") var forecastGenerator: String,
    @JsonProperty("generatedAt") var generatedAt: String,
    @JsonProperty("updateTime") var updateTime: String,
    @JsonProperty("validTimes") var validTimes: String,
    @JsonProperty("elevation") var elevation: UnitCodeValue,
    @JsonProperty("periods") var periods: Array<Periods>?
)
