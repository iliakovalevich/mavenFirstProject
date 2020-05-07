package com.laba1;

import java.util.ArrayList;
import java.util.List;

public class BillingServices {
  private int horoscopeBilling = 0;
  private int weatherBilling = 0;
  final InputOutputConsole inputOutputConsole = new InputOutputConsole();
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
    switchDataFromResources();
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

  private void switchDataFromResources() {
    switch (inputOutputConsole.inputNumberOfMenu(0, 4)) {
      case 1:
        caseTxt();
        break;
      case 2:
        caseJson();
        break;
      case 3:
        caseCsv();
        break;
      case 4:
        caseDataBase();
        break;
      default:
        System.out.println("Number is not 0-3");
    }
  }

  public void caseDataBase() {
    horoscopeList = new ReadFromDataBase().readHoroscopeForecasts();
    weatherList = new ReadFromDataBase().readWeatherForecasts();
  }

  public void caseTxt() {
    horoscopeList = new ReadTxtFile().readHoroscopeForecasts();
    weatherList = new ReadTxtFile().readWeatherForecasts();
  }

  public void caseCsv() {
    horoscopeList = new ReadCsvFile().readHoroscopeForecasts();
    weatherList = new ReadCsvFile().readWeatherForecasts();
  }

  public void caseJson() {
    horoscopeList = new ReadJsonFile().readHoroscopeForecasts();
    weatherList = new ReadJsonFile().readWeatherForecasts();
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
