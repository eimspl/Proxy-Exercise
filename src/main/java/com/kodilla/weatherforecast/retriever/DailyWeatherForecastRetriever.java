package com.kodilla.weatherforecast.retriever;

import java.time.DayOfWeek;
import java.util.Random;

public class DailyWeatherForecastRetriever implements WeatherForecastRetriever {
    private int windStrength;
    private double fallLevel;
    private int minTemperature;
    private int maxTemperature;
    private String weather;
    private final DayOfWeek dayOfWeek;


    public DailyWeatherForecastRetriever(int dayOfWeekIndex) throws InterruptedException {
        this.dayOfWeek = DayOfWeek.of(dayOfWeekIndex);
        this.refreshData();
    }

    public DailyWeatherForecastRetriever(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        this.initWeatherInfo();
    }

    @Override
    public String getWeather() {
        return this.weather;
    }

    @Override
    public String refreshData() throws InterruptedException {
        Thread.sleep(5000);
        initWeatherInfo();
        return this.weather;
    }

    private void initWeatherInfo() {
        WeatherType weatherType = WeatherType.getType((int) new Random().nextInt(4) + 1);
        this.initLowestTemperature(weatherType);
        this.initHighestTemperature(weatherType);
        this.initFallLevel(weatherType);
        this.initWindStrength(weatherType);
        this.weather = String.format("Weather forecast for %s:\n%s, temperature: %d - %d C, rain level: %.1f, wind strength: %d",
                this.dayOfWeek.name(), weatherType, minTemperature, maxTemperature, fallLevel, windStrength);
    }

    private void initLowestTemperature(WeatherType weatherType) {
        if (weatherType.ordinal() == 0) {
            this.minTemperature = (int) ((Math.random() * (15)) - 10);
        } else {
            this.minTemperature = weatherType.ordinal() + (int) ((Math.random() * (18 - 6)) + 6);
        }
    }

    private void initHighestTemperature(WeatherType weatherType) {
        if (weatherType.ordinal() == 0) {
            this.maxTemperature = (int) ((Math.random() * (18 - 5)) + 5);
        } else {
            this.maxTemperature = weatherType.ordinal() + (int) ((Math.random() * (27 - 18)) + 18);
        }
    }

    void initFallLevel(WeatherType weatherType) {
        this.fallLevel = switch (weatherType.ordinal()) {
            case 0 -> Math.random() * (5) + 5;
            case 1 -> Math.random() * (7) + 5;
            case 2 -> Math.random() * (5) + 10;
            case 3 -> Math.random() * (2) + 3;
            case 4 -> Math.random() * (1);
            default -> 0.0;
        };
    }

    private void initWindStrength(WeatherType weatherType) {
        this.windStrength = switch (weatherType.ordinal()) {
            case 0 -> (int) (Math.random() * (2)) + 5;
            case 1 -> (int) (Math.random() * (3)) + 7;
            case 2 -> (int) (Math.random() * (3)) + 5;
            case 3 -> (int) (Math.random() * (2)) + 3;
            case 4 -> (int) (Math.random() * (2));
            default -> 0;
        };
    }

}
