package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Configuration {

    var FORECAST_REPORT_ENDPOINT: String = "https://api.weather.gov/gridpoints/MLB/33,70/forecast"

    @Bean
    fun webClient(builder: WebClient.Builder): WebClient =
        builder
            .baseUrl(FORECAST_REPORT_ENDPOINT)
            .build()
}