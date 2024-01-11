package com.example.demo.controller

import com.example.demo.data.ForcastRepository
import com.example.demo.model.TemperatureReport
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weather-forcast")
class Controller {
    @GetMapping("/today")
    fun getCurrentDayTemperatureReport(): TemperatureReport? {
        return ForcastRepository().getCurrentDayTemperatureReport();
    }
}