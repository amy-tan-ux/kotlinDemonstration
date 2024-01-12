package com.example.demo.model

data class TemperatureReport(

    var daily: Array<ReportDetails>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TemperatureReport

        return daily.contentEquals(other.daily)
    }

    override fun hashCode(): Int {
        return daily.contentHashCode()
    }
}

data class ReportDetails(
    var day_name: String?,
    var temp_high_celsius: Double?,
    var forecast_blurb: String?
)
