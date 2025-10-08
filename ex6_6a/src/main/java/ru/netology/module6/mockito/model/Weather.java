package ru.netology.module6.mockito.model;

public enum Weather {
    RAINY("Дождливо"),
    STORMY("Ветренно"),
    SUNNY("Солнечно"),
    CLOUDY("Облачно");

    private final String weather;

    Weather(String weather){
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }
}
