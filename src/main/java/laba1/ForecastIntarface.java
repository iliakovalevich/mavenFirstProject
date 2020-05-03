package laba1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public interface ForecastIntarface {
    double HOROSCOPE_COST=3.0;
    double WEATHER_COST=2.0;
    Random random=new Random();
    HashMap<Date, String> dateAndForecast = new HashMap<>();
    String randomForecast(ArrayList<String> forecastsHoroscopeList);
    String randomWeather(Date date,ArrayList<String> forecastsWeatherList);
    String randomWeather(ArrayList<String> forecastsWeatherList);
    String payBilling(int horoscopeBilling,int weatherBilling);
}
