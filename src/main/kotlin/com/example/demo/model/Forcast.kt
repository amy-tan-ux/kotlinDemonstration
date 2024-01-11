package com.example.demo.model

import com.example.demo.model.forecast.Geometry
import com.example.demo.model.forecast.Properties
data class Forcast(
    var context: Pair<String, Map<String,String>>?,
    var type: String?,
    var geometry: Geometry?,
    var properties: List<Properties>?,
)
