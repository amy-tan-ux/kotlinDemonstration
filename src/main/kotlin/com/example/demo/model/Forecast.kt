package com.example.demo.model

import com.example.demo.model.forecast.Geometry
import com.example.demo.model.forecast.Properties
import com.fasterxml.jackson.annotation.JsonProperty

data class Forecast(
    @JsonProperty("@context") var context: Array<Any?>?,
    @JsonProperty("type") var type: String?,
    @JsonProperty("geometry") var geometry: Geometry?,
    @JsonProperty("properties") var properties: Properties,
)
