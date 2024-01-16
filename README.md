DAILY WEATHER FORCAST API

Creating daily reports continaing temperature high and forcast summary 
using the government weather api: https://api.weather.gov/gridpoints/MLB/33,70/forecast

HOW TO INSTALL AND RUN THE PROJECT

Technology:
- Java 17, JVM 17, JDK 17
- Kotlin 2.0.0-Beta2

HOW TO USE THE PROJECT

This api is not hosted so it has to be ran on localhost port 8080:

localhost:8080/weather-forecast/current-day-report 
This endpoint gives you the daily report

localhost:8080/weather-forecast/full-report
This endpoint gives you the full forcast-report (same as the government weather api)
