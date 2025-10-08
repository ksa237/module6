package ru.netology.module6.mockito.model;

public enum Preference {
    FOOTBALL("Сыграть в футбол"),
    WALKING("Выйти на прогулку"),
    WATCHING_FILMS("Посмотреть кино дома"),
    READING("Почитать книгу");

    private final String value;

    Preference(String value){
        this.value = value;

    }

    public String getValue(){
        return value;
    }
}

