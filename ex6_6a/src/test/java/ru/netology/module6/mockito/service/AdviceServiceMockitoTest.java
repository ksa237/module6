package ru.netology.module6.mockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import ru.netology.module6.mockito.model.Preference;
import ru.netology.module6.mockito.model.Weather;
import ru.netology.module6.mockito.service.impl.WeatherServiceImpl;

import java.util.Set;

public class AdviceServiceMockitoTest {


    @Test
    void test_get_advice_bad_weather() {

        WeatherService weatherService = Mockito.mock(WeatherService.class);
        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);

        AdviceService adviceService = new AdviceService(preferencesService, weatherService);

        Mockito.when(weatherService.currentWeather()).thenReturn(Weather.RAINY);

        Set<Preference> userPreferences = Set.of(Preference.FOOTBALL, Preference.READING, Preference.WATCHING_FILMS);

        Mockito.when(preferencesService.get("user1")).thenReturn(userPreferences);

        Set<Preference> preferences = adviceService.getAdvice("user1");
        Set<Preference> expected = Set.of(Preference.READING, Preference.WATCHING_FILMS);

        Assertions.assertEquals(expected, preferences);
        Mockito.verify(preferencesService, Mockito.times(1)).get("user1");
        Mockito.verify(preferencesService, Mockito.times(0)).get("user2");
    }

    @Test
    void test_spy_weather_service() {

        WeatherService weatherService = Mockito.spy(WeatherServiceImpl.class);
        Assertions.assertEquals(Weather.SUNNY, weatherService.currentWeather());

    }

    @Test
    void test_get_advice_in_bad_weather_captor(){

        WeatherService weatherService = Mockito.mock(WeatherService.class);
        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);



        Mockito.when(weatherService.currentWeather()).thenReturn(Weather.STORMY);
        Mockito.when(preferencesService.get(Mockito.any())).thenReturn(Set.of(Preference.FOOTBALL));

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        AdviceService adviceService = new AdviceService(preferencesService, weatherService);

        adviceService.getAdvice("user1");

        Mockito.verify(preferencesService).get(argumentCaptor.capture());

        Assertions.assertEquals("user1", argumentCaptor.getValue());








    }
}
