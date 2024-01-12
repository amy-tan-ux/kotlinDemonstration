package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty

data class UnitCodeValue(
    @JsonProperty("unitCode") var unitCode: String?,
    @JsonProperty("value") var value: String?
)
