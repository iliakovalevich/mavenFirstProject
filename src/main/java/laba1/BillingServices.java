package laba1;

import java.io.FileNotFoundException;

public class BillingServices {
    private final static String horoscopeFile="resources/horoscope.txt";
    private final static String weatherFile="resources/horoscope.txt";
    private int horoscopeBilling=0;
    private int weatherBilling=0;
    final InputOutputConsole inputOutputConsole = new InputOutputConsole();
    final InputOutputFile inputOutputFile = new InputOutputFile();
    final Forecast forecast = new Forecast();
    public static void main(String[] args) {
        try{
            BillingServices billingServices=new BillingServices();
            billingServices.menu();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void menu() throws FileNotFoundException {
        while(true){
            inputOutputConsole.printMenu();
            switch (inputOutputConsole.inputNumberOfMenu(0,2)){
                case 1:
                    caseHoroscope();
                    horoscopeBilling++;
                    break;
                case 2:
                    caseWeather();
                    weatherBilling++;
                    break;
                case 0:
                    System.out.println(forecast.payBilling(horoscopeBilling,weatherBilling));
                    return;
            }
        }
    }
    private void caseHoroscope() throws FileNotFoundException {
        inputOutputConsole.inputDate("date of birthday ");
        inputOutputConsole.printPeriod();
        switch (inputOutputConsole.inputNumberOfMenu(1,3)) {
            case 1:
            case 2:
            case 3:
                System.out.println(forecast.randomForecast(inputOutputFile.readTxtFile(horoscopeFile)));
                break;
        }
    }
    private void caseWeather() throws FileNotFoundException {
        inputOutputConsole.printPeriod();
        switch (inputOutputConsole.inputNumberOfMenu(1,3)) {
            case 1:
                System.out.println(forecast.randomWeather(inputOutputConsole.inputDate("date of forecast"),inputOutputFile.readTxtFile(weatherFile)));
                break;
            case 2:
            case 3:
                System.out.println(forecast.randomWeather(inputOutputFile.readTxtFile(weatherFile)));
                break;
        }
    }
}