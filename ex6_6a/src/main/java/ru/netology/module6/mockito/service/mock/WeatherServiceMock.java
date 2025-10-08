package ru.netology.module6.mockito.service.mock;

import ru.netology.module6.mockito.model.Weather;
import ru.netology.module6.mockito.service.WeatherService;

public class WeatherServiceMock implements WeatherService {

    private Weather value;

    public WeatherServiceMock(Weather weather) {
        this.value = Weather.STORMY;
    }

    public WeatherServiceMock() {
        this.value = value;
    }

    @Override
    public Weather currentWeather() {
        return value;
    }

    public void setValue(Weather value){
        this.value = value;
    }

}
