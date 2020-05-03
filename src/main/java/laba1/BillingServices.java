package laba1;

import java.io.FileNotFoundException;

public class BillingServices implements Billing {
  private int horoscopeBilling = 0;
  private int weatherBilling = 0;

  public static void main(String[] args) {
    try {
      BillingServices billingServices = new BillingServices();
      billingServices.menu();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  public void menu() throws FileNotFoundException {
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
