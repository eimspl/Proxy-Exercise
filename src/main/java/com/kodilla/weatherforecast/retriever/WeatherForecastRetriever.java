package com.kodilla.weatherforecast.retriever;

public interface WeatherForecastRetriever {
    String getWeather() throws InterruptedException;

    String refreshData() throws InterruptedException;
}
