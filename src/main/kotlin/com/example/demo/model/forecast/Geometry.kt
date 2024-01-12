package com.example.demo.model.forecast

import com.fasterxml.jackson.annotation.JsonProperty

data class Geometry(
    @JsonProperty("type") var type: String?,
    @JsonProperty("coordinates") var coordinates: Array<Array<Array<String>>>

)
