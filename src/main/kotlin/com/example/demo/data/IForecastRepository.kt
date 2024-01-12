package com.example.demo.data

import com.example.demo.model.Forecast

interface IForecastRepository {
    fun getForecast(): Forecast?
}