package com.example.demo.services

import com.example.demo.config.Configuration
import com.example.demo.model.Forecast
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient


@Service
class GenerateForecastWebService {
    private val webClient: WebClient = Configuration().webClient(WebClient.builder())
    fun getUpdatedWeatherForecast(): Forecast? =
        webClient.get()
            .uri("https://api.weather.gov/gridpoints/MLB/33,70/forecast")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(object : ParameterizedTypeReference<Forecast?>() {})
            .block()
}

