package com.example.demo.services

import com.example.demo.data.ForecastRepository
import com.example.demo.model.Forecast
import com.example.demo.model.ReportDetails
import com.example.demo.model.TemperatureReport
import com.example.demo.model.UnitCodeValue
import com.example.demo.model.forecast.Periods
import com.example.demo.model.forecast.Properties
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GenerateCurrentDayReportTest {

    val MOCK_ARRAY_OF_PERIODS: Array<Periods> = getTestArrayOfPeriods()

    @Test
    fun getCurrentDayTemperatureSuccess_Test() {
        val mockForecastRepository = Mockito.mock(ForecastRepository::class.java)
        Mockito.`when`(mockForecastRepository.getForecast()).thenReturn(getTestForecastObject())
        val expectedTemperatureReport =
            TemperatureReport(
                daily = arrayOf(
                    ReportDetails(
                        day_name = "Friday",
                        temp_high_celsius = DecimalFormat("#,##0.0").format((5 * (40 + (2L * 1).toFloat() - 32)) / 9)
                            .toDouble(),
                        forecast_blurb = " Test Short Forecast For 0. Test Short Forecast For 1."
                    )
                )
            )
        Assertions.assertEquals(
            expectedTemperatureReport,
            GenerateCurrentDayReport(mockForecastRepository).getCurrentDayTemperatureReport()
        )

    }

    private fun getTestForecastObject(): Forecast =
        Forecast(
            context = arrayOf(
                "testlink",
                mapOf(Pair("testMapKey1", "testMapDescription1"), Pair("testMapKey2", "testMapDescription2"))
            ),
            type = "testTypeLink",
            geometry = null,
            properties = Properties(
                updated = MOCK_ARRAY_OF_PERIODS[0].startTime,
                units = "test unit",
                forecastGenerator = "test forecast generator",
                generatedAt = MOCK_ARRAY_OF_PERIODS[0].startTime,
                updateTime = MOCK_ARRAY_OF_PERIODS[0].startTime,
                validTimes = MOCK_ARRAY_OF_PERIODS[0].startTime,
                elevation = UnitCodeValue(unitCode = null, value = null),
                periods = MOCK_ARRAY_OF_PERIODS
            )
        )

    private fun getTestArrayOfPeriods(): Array<Periods> {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
        val mockUpdatedDateTime = "2024-01-12T06:00:00-05:00"
        var arrayOfPeriods: Array<Periods> = arrayOf()

        for (index in 0..6) {
            arrayOfPeriods +=
                Periods(
                    number = index,
                    name = "name$index",
                    startTime = LocalDateTime.parse(mockUpdatedDateTime, formatter).plusHours(12L * index)
                        .toString() + ":00-05:00", // Mock Eastern Timezone
                    endTime = LocalDateTime.parse(mockUpdatedDateTime, formatter).plusHours(12L * (index + 1))
                        .toString() + ":00-05:00",
                    isDaytime = index % 2 == 0,
                    temperature = (40 + (2L * index)).toString(),
                    temperatureUnit = "F",
                    temperatureTrend = null,
                    probabilityOfPrecipitation = UnitCodeValue(unitCode = null, value = null),
                    dewpoint = UnitCodeValue(unitCode = null, value = null),
                    relativeHumidity = UnitCodeValue(unitCode = null, value = null),
                    windSpeed = "windspeed$index",
                    windDirection = "winddirection$index",
                    icon = "icon$index",
                    shortForecast = "Test Short Forecast For $index",
                    detailedForecast = "A More Longer and Detailed Long Forecast for $index"
                )
        }

        return arrayOfPeriods
    }
}