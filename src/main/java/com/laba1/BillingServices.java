package com.laba1;

public class BillingServices {
  private int horoscopeBilling = 0;
  private int weatherBilling = 0;
  static final String horoscopeFile = "horoscope.txt";
  static final String weatherFile = "weather.txt";
  InputOutputConsole inputOutputConsole = new InputOutputConsole();
  InputOutputFile inputOutputFile = new InputOutputFile();
  Forecast forecast = new Forecast();

  public static void main(String[] args) {
    try {
      BillingServices billingServices = new BillingServices();
      billingServices.menu();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  public void menu() {
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
          System.out.println("");
      }
    }
  }

  public void caseHoroscope() {
    inputOutputConsole.inputDate("date of birthday ");
    inputOutputConsole.printPeriod();
    inputOutputConsole.inputNumberOfMenu(1, 3);
    System.out.println(forecast.randomForecast(inputOutputFile.readTxtFile(horoscopeFile)));
  }

  public void caseWeather() {
    inputOutputConsole.printPeriod();
    switch (inputOutputConsole.inputNumberOfMenu(1, 3)) {
      case 1:
        System.out.println(
            forecast.randomWeather(
                inputOutputConsole.inputDate("date of forecast"),
                inputOutputFile.readTxtFile(weatherFile)));
        break;
      case 2:
      case 3:
        System.out.println(forecast.randomWeather(inputOutputFile.readTxtFile(weatherFile)));
        break;
    }
  }
}
