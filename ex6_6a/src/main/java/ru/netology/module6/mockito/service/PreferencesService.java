package ru.netology.module6.mockito.service;

import ru.netology.module6.mockito.model.Preference;

import java.util.Set;

public interface PreferencesService {

    Set<Preference> get (String userId);


}
