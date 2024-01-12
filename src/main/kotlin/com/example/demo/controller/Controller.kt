package com.example.demo.controller

import com.example.demo.data.ForecastRepository
import com.example.demo.model.Forecast
import com.example.demo.model.TemperatureReport
import com.example.demo.services.GenerateCurrentDayReport
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weather-forecast")
class Controller {
    @GetMapping("/current-day-report")
    fun getCurrentDayTemperatureReport(): TemperatureReport? {
        return GenerateCurrentDayReport(ForecastRepository()).getCurrentDayTemperatureReport()
    }

    @GetMapping("/full-report")
    fun getFullForecast(): Forecast? {
        return ForecastRepository().getForecast()
    }

}