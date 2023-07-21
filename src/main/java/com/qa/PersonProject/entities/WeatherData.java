package com.qa.PersonProject.entities;

public class WeatherData {
    private String name; // City name
    private Main main; // Weather details like temperature, pressure, humidity, etc.

    // Getters and Setters (you can use your IDE to generate them)

    public static class Main {
        private double temp; // Temperature in Kelvin
        private int pressure; // Pressure in hPa
        private int humidity; // Humidity in percentage

        // Getters and Setters
    }
}

