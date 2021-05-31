package com.kodilla.weatherforecast.retriever;

public enum WeatherType {

    SNOW,
    STORM,
    RAIN,
    CLOUDY,
    SUNNY;

    public static WeatherType getType(int i) {
        return values()[i];
    }

    public static int listGetLastIndex() {
        return values().length - 1;
    }

}
