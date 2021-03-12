package com.eoayem.sunshine;

import java.io.Serializable;

public class Weather implements Serializable {

    public static final String WEATHER_TAG = "WEATHER";

    private String dateTime;
    private String maxTemp;
    private String minTemp;
    private String typeWeather;
    private int imageWeather;
    private String address;

    public Weather(String dateTime, String maxTemp, String minTemp, String typeWeather, int imageWeather, String address) {
        this.dateTime = dateTime;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.typeWeather = typeWeather;
        this.imageWeather = imageWeather;
        this.address = address;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getTypeWeather() {
        return typeWeather;
    }

    public void setTypeWeather(String typeWeather) {
        this.typeWeather = typeWeather;
    }

    public int getImageWeather() {
        return imageWeather;
    }

    public void setImageWeather(int imageWeather) {
        this.imageWeather = imageWeather;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
