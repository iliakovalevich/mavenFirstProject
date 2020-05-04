package com.laba1;

import java.util.ArrayList;
import java.util.List;

public class BillingServices {
  private int horoscopeBilling = 0;
  private int weatherBilling = 0;
  static final String horoscopeFile = "horoscope.txt";
  static final String weatherFile = "weather.txt";
  static final String weatherFileJson = "weatherForecast.json";
  static final String horoscopeFileJson = "horoscopeForecast.json";
  final InputOutputConsole inputOutputConsole = new InputOutputConsole();
  final InputOutputFile inputOutputFile = new InputOutputFile();
  final Forecast forecast = new Forecast();
  List<String> horoscopeList = new ArrayList<>();
  List<String> weatherList = new ArrayList<>();

  public static void main(String[] args) {
    try {
      BillingServices billingServices = new BillingServices();
      billingServices.menu();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  public void menu() {
    inputOutputConsole.printOutputFile();
    switch (inputOutputConsole.inputNumberOfMenu(0, 2)) {
      case 1:
        caseTxt();
        break;
      case 2:
        caseJson();
        break;
      default:
        System.out.println("Number is not 0-2");
    }
    while (true) {
      inputOutputConsole.printMenu();
      switch (inputOutputConsole.inputNumberOfMenu(0, 2)) {
        case 1:
          caseHoroscope();
          horoscopeBilling++;
          break;
        case 2:
          caseWeather();
          weatherBilling++;
          break;
        case 0:
          System.out.println(forecast.payBilling(horoscopeBilling, weatherBilling));
          return;
        default:
          System.out.println("Number is not 0-2");
      }
    }
  }

  public void caseTxt() {
    horoscopeList = inputOutputFile.readTxtFile(horoscopeFile);
    weatherList = inputOutputFile.readTxtFile(weatherFile);
  }

  public void caseJson() {
    horoscopeList = inputOutputFile.readJsonFile(horoscopeFileJson, "horoscope");
    weatherList = inputOutputFile.readJsonFile(weatherFileJson, "weather");
  }

  public void caseHoroscope() {
    inputOutputConsole.inputDate("date of birthday ");
    inputOutputConsole.printPeriod();
    inputOutputConsole.inputNumberOfMenu(1, 3);
    System.out.println(forecast.randomForecast(horoscopeList));
  }

  public void caseWeather() {
    inputOutputConsole.printPeriod();
    switch (inputOutputConsole.inputNumberOfMenu(1, 3)) {
      case 1:
        System.out.println(
            forecast.randomWeather(inputOutputConsole.inputDate("date of forecast"), weatherList));
        break;
      case 2:
      case 3:
        System.out.println(forecast.randomWeather(weatherList));
        break;
      default:
        System.out.println("The input number must be between from 0 to 3!");
    }
  }
}
