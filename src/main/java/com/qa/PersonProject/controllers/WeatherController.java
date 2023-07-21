package com.qa.PersonProject.controllers;

import com.qa.PersonProject.entities.WeatherData;
import com.qa.PersonProject.services.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{city}")
    public WeatherData getWeather(@PathVariable String city) throws IOException {
        return weatherService.getWeatherData(city);
    }
}

