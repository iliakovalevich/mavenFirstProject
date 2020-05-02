package laba1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

class Forecast {
    final static double HOROSCOPE_COST=3.0;
    final static double WEATHER_COST=2.0;
    final Random random=new Random();
    final HashMap<Date, String> dateAndForecast = new HashMap<>();
    protected String randomForecast(ArrayList<String> forecastsHoroscopeList) {
        int firstForecast;
        int secondForecast;
        firstForecast= (random.nextInt(forecastsHoroscopeList.size()));
        secondForecast= (random.nextInt(forecastsHoroscopeList.size()));
        while (true) {
                if (firstForecast!=secondForecast) {//create random predictions so that the same ones do not repeat
                return forecastsHoroscopeList.get(firstForecast) + "\n" + forecastsHoroscopeList.get(secondForecast);
                } else {
                secondForecast= (random.nextInt(forecastsHoroscopeList.size()));
            }
        }
    }
    protected String randomWeather(Date date,ArrayList<String> forecastsWeatherList){
        if (!dateAndForecast.containsKey(date)) {
            dateAndForecast.put(date, forecastsWeatherList.get((random.nextInt(forecastsWeatherList.size()))));
        }
        return dateAndForecast.get(date);
    }
    protected String randomWeather(ArrayList<String> forecastsWeatherList){
        return forecastsWeatherList.get((random.nextInt(forecastsWeatherList.size())));
    }
    protected String payBilling(int horoscopeBilling,int weatherBilling) {
        return ("horoscope 3.0$"+"\n"+"weather 2.0$"+"\n"
                +"You used the horoscope "+horoscopeBilling+" times "+"3.0$ x "+horoscopeBilling+" = "+horoscopeBilling*HOROSCOPE_COST+"\n"
                +"You used the forecast weather "+weatherBilling+" times "+"2.0$ x "+weatherBilling+" = "+weatherBilling*WEATHER_COST+"\n"+
                "You have to pay "+((horoscopeBilling*HOROSCOPE_COST)+(weatherBilling*WEATHER_COST))+"$");
    }
}
