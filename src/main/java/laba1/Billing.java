package laba1;

import java.io.FileNotFoundException;

public interface Billing {
    String horoscopeFile="horoscope.txt";
    String weatherFile="weather.txt";
    InputOutputConsole inputOutputConsole = new InputOutputConsole();
    InputOutputFile inputOutputFile = new InputOutputFile();
    Forecast forecast = new Forecast();
    void menu() throws FileNotFoundException;
    void caseHoroscope() throws FileNotFoundException;
    void caseWeather() throws FileNotFoundException;
}
