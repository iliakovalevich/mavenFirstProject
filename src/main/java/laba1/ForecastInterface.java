package laba1;

import java.util.*;

public interface ForecastInterface {
  double HOROSCOPE_COST = 3.0;
  double WEATHER_COST = 2.0;
  Random random = new Random();
  Map<Date, String> dateAndForecast = new HashMap<>();

  String randomForecast(List<String> forecastsHoroscopeList);

  String randomWeather(Date date, List<String> forecastsWeatherList);

  String randomWeather(List<String> forecastsWeatherList);

  String payBilling(int horoscopeBilling, int weatherBilling);
}
