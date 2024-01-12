package com.example.demo.model

data class TemperatureReport(

    var daily: Array<ReportDetails>
)

data class ReportDetails(
    var day_name: String?,
    var temp_high_celsius: Double?,
    var forecast_blurb: String?
)
