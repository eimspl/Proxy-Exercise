package com.kodilla.weatherforecast;

import com.kodilla.weatherforecast.retriever.WeatherForecastRetriever;
import com.kodilla.weatherforecast.retriever.proxy.LazyDailyWeatherForecastRetriever;

import java.util.Random;

public class WeatherProxyApp {

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        for (int dayIndex = 1; dayIndex <= 7; dayIndex++) {
            WeatherForecastRetriever forecastRetriever = new LazyDailyWeatherForecastRetriever(dayIndex);
            System.out.println(forecastRetriever.getWeather() + "\n");
            int number = new Random().nextInt(100);
            if (number < 20) {
                System.out.println("----------REFRESHED-----------\n"
                        + forecastRetriever.refreshData() + "\n");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("The execution took: " + (end - begin) + " [ms]");
    }

}