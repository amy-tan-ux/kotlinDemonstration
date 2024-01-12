package com.example.demo.data

import com.example.demo.model.Forecast
import com.example.demo.services.GenerateForecastWebService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class ForecastRepository : IForecastRepository {

    private var updatedForecast: Forecast? = null

    override fun getForecast(): Forecast? {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")

        if (this.updatedForecast == null) {
            /** Initialization the in-memory forecast record**/
            this.updatedForecast = GenerateForecastWebService().getUpdatedWeatherForecast()
        } else if ((LocalDateTime.parse(this.updatedForecast?.properties?.updated, formatter).hour < 15 &&
                    /** The time changes to Afternoon(or Today) at 16:00:00 and then overwrite the period to exclude the morning report
                    // Restricting refresh will ensure we get the most accurate reporting **/
                    LocalDateTime.parse(this.updatedForecast?.properties?.updated, formatter)
                        .plusMinutes(30) < LocalDateTime.now()) ||
            /** placed a limit to 1 refresh every 30 minutes to reduce the necessary calls to the api endpoint
            // only update the forecast report in the morning or if we haven't refreshed the forecast for more than a day
            // Note: This is to ensure we get enough data to do the Current Day Temperature Report **/
            LocalDateTime.parse(this.updatedForecast?.properties?.updated, formatter)
                .plusHours(24) < LocalDateTime.now()
        ) {

            this.updatedForecast = GenerateForecastWebService().getUpdatedWeatherForecast()
        }
        return this.updatedForecast
    }

}
