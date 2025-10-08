package ru.netology.module6.mockito.service.impl;

import ru.netology.module6.mockito.model.Weather;
import ru.netology.module6.mockito.service.WeatherService;

public class WeatherServiceImpl implements WeatherService {


    @Override
    public Weather currentWeather() {
        return Weather.SUNNY;
    }
}
