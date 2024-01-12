package com.example.demo.services

import com.example.demo.data.IForecastRepository
import com.example.demo.model.Forecast
import com.example.demo.model.ReportDetails
import com.example.demo.model.TemperatureReport
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GenerateCurrentDayReport(
    val forecastRepository: IForecastRepository
) {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")

    fun getCurrentDayTemperatureReport(): TemperatureReport {
        return TemperatureReport(arrayOf(calculateReportDetails(forecastRepository.getForecast())))
    }

    private fun calculateReportDetails(forecast: Forecast?): ReportDetails {

        if (forecast == null || forecast.properties.periods == null) {
            return ReportDetails(day_name = null, temp_high_celsius = null, forecast_blurb = null)
        } else {
            // The temp_high_celsius_value will be the maximum of the 3 time periods in the day
            var tempHighCelsiusValue = 0.0
            // The forecast_blurb will be a concatenation of the shortForecasts throughout the day
            var forecastBlurb = ""
            val dayNameValue: String =
                LocalDateTime.parse(forecast.properties.updateTime, formatter).dayOfWeek.toString()

            for (period in forecast.properties.periods!!) {
                if (LocalDateTime.parse(
                        period.startTime,
                        formatter
                    ).dayOfWeek.toString() == dayNameValue && LocalDateTime.parse(period.startTime, formatter).hour > 5
                ) {

                    val reportedTemperatureInCelsius: Double =
                        if (period.temperatureUnit == "F") (5 * (period.temperature.toDouble() - 32)) / 9 // F to Celsius
                        else period.temperature.toDouble()

                    if (reportedTemperatureInCelsius > tempHighCelsiusValue) {

                        tempHighCelsiusValue = reportedTemperatureInCelsius
                    }
                    forecastBlurb += " " + period.shortForecast + "."
                } else if (forecastBlurb != "") {
                    break
                }
            }

            return ReportDetails(
                day_name = dayNameValue[0].uppercase() + dayNameValue.substring(1).lowercase(),
                temp_high_celsius = DecimalFormat("#,##0.0").format(tempHighCelsiusValue).toDouble(),
                forecast_blurb = forecastBlurb
            )
        }
    }

}