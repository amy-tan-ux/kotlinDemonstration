package com.example.demo.data

import com.example.demo.exception.ForecastNotRetrievable
import com.example.demo.model.Forecast
import com.example.demo.services.GenerateForecastWebService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class ForecastRepository : IForecastRepository {
    private var updatedForecast: Forecast? = null
    private val logger = LoggerFactory.getLogger(this.javaClass.name)
    override fun getForecast(): Forecast? {

        try {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")

            if (this.updatedForecast == null) {
                /** Initialization the in-memory forecast record**/
                this.updatedForecast = GenerateForecastWebService().getUpdatedWeatherForecast()
                logger.info("Initial Forecast Record Recorded")
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
                logger.info("Forecast Records Updated at [{}]", LocalDateTime.now())
            }
            return this.updatedForecast
        } catch (e: Exception) {
            logger.error("Could Not Retrieve Forecast Records. Error [{}]", e.message)
            throw ForecastNotRetrievable("Could Not Retrieve Forecast Records. Error:", e)
        }
    }

}
