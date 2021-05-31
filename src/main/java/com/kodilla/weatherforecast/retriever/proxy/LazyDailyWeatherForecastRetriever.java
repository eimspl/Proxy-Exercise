package com.kodilla.weatherforecast.retriever.proxy;

import com.kodilla.weatherforecast.retriever.DailyWeatherForecastRetriever;
import com.kodilla.weatherforecast.retriever.WeatherForecastRetriever;

import java.time.DayOfWeek;

public class LazyDailyWeatherForecastRetriever implements WeatherForecastRetriever {
    WeatherForecastRetriever weatherForecastRetriever;

    final private int dayOfWeekIndex;

    public LazyDailyWeatherForecastRetriever(int dayOfWeekIndex) throws InterruptedException {
        this.dayOfWeekIndex = dayOfWeekIndex;
        weatherForecastRetriever = new DailyWeatherForecastRetriever(DayOfWeek.of(dayOfWeekIndex));
    }

    @Override
    public String getWeather() throws InterruptedException {
        if (weatherForecastRetriever == null)
            weatherForecastRetriever = new DailyWeatherForecastRetriever(this.dayOfWeekIndex);
        return weatherForecastRetriever.getWeather();
    }

    @Override
    public String refreshData() throws InterruptedException {
        if (weatherForecastRetriever == null)
            weatherForecastRetriever = new DailyWeatherForecastRetriever(this.dayOfWeekIndex);
        return weatherForecastRetriever.refreshData();
    }
}
