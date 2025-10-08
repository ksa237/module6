package ru.netology.module6.mockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.module6.mockito.model.Preference;
import ru.netology.module6.mockito.model.Weather;
import ru.netology.module6.mockito.service.mock.PreferencesServiceMock;
import ru.netology.module6.mockito.service.mock.WeatherServiceMock;

import java.util.Set;

public class AdviceServiceWithMockTest {


    @Test
    void test_get_advice_bad_weather(){

        WeatherServiceMock weatherService = new WeatherServiceMock();
        PreferencesServiceMock preferencesService = new PreferencesServiceMock();

        weatherService.setValue(Weather.STORMY);

        preferencesService.setValue(Set.of(
                Preference.FOOTBALL,
                Preference.READING,
                Preference.WATCHING_FILMS
        ));


        AdviceService adviceService = new AdviceService(preferencesService, weatherService);

        Set<Preference> preferences = adviceService.getAdvice("user3");

        Set<Preference> expected = Set.of(Preference.WATCHING_FILMS, Preference.READING);

        Assertions.assertEquals(expected, preferences);

    }



}
