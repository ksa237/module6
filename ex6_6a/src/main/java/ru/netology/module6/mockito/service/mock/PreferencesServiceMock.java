package ru.netology.module6.mockito.service.mock;

import ru.netology.module6.mockito.model.Preference;
import ru.netology.module6.mockito.service.PreferencesService;

import java.util.Set;
import java.util.prefs.Preferences;

public class PreferencesServiceMock implements PreferencesService {

    private Set<Preference> value;

    public PreferencesServiceMock() {
        this.value = Set.of(Preference.FOOTBALL, Preference.READING );
    }

    public PreferencesServiceMock(Set<Preference> preferences){
        this.value = preferences;
    }

    @Override
    public Set<Preference> get(String userId) {
        return value;
    }

    public void setValue(Set<Preference> value){
        this.value = value;
    }

}
