package com.example.demo.data

import com.example.demo.model.Forcast
import com.example.demo.model.TemperatureReport
import org.springframework.stereotype.Service
import java.time.format.DateTimeFormatter

@Service
class ForcastRepository {

    var updatedForcast: Pair<DateTimeFormatter?, Forcast?> =
        Pair(null, Forcast(context = null, type = null, geometry = null, properties = null))
    fun getForcast(): Forcast? {
        return updatedForcast.second
    }

    fun getCurrentDayTemperatureReport(): TemperatureReport {

        var currentForcast: Forcast? = getForcast()
        // Temporary mock pojo
        return TemperatureReport(name = "name", temp_high_celsius = 29.4, forcast_blurp = "test")


    }
}
