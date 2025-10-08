package ru.netology.module6.mockito.service;

import ru.netology.module6.mockito.model.Preference;
import ru.netology.module6.mockito.model.Weather;

import java.util.Set;

public class Main {


    public static void main(String[] args) {

        WeatherService weatherService = new WeatherService() {
            @Override
            public Weather currentWeather() {
                return Weather.SUNNY;
            }
        };


        PreferencesService preferencesService = new PreferencesService() {
            @Override
            public Set<Preference> get(String userId) {
                return Set.of(Preference.FOOTBALL,
                        Preference.WALKING,
                        Preference.WATCHING_FILMS,
                        Preference.READING
                );
            }
        };

        AdviceService adviceService = new AdviceService(preferencesService, weatherService);

        Set<Preference> sunnyAdvice = adviceService.getAdvice("user2");

        System.out.println(sunnyAdvice);
    }




}
