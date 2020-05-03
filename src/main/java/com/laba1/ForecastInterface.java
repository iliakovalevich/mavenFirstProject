package com.laba1;

import java.util.Date;
import java.util.List;

public interface ForecastInterface {
  String randomForecast(List<String> forecastsHoroscopeList);

  String randomWeather(Date date, List<String> forecastsWeatherList);

  String randomWeather(List<String> forecastsWeatherList);

  String payBilling(int horoscopeBilling, int weatherBilling);
}
