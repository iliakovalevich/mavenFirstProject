package laba1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class InputOutputConsole  {
    protected void printMenu(){
        System.out.println("1-horoscope");
        System.out.println("2-weather forecast");
        System.out.println("0-exit");
    }
    protected int inputNumberOfMenu(int minValue,int maxValue){
        Scanner sc=new Scanner(System.in);
        int count;
        while(true) {
            try {
                count = Integer.parseInt(sc.nextLine());
                if(count>=minValue && count<=maxValue) {
                    break;
                }
                else{
                    throw new Exception("The input number must be between from 0 to 3!");
                }
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return count;
    }
    protected void printPeriod(){
        LocalDate date = LocalDate.now(); // получаем текущую дату
        System.out.println("1-Forecast on the your day");
        System.out.println("2-Forecast on the week");
        System.out.println("3-Forecast on the "+date.getMonth()+" month ");
    }
    protected Date inputDate(String s){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the "+s+" dd-MM-yyyy");
        String date = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date2=null;
        try {
            //Parsing the String
            date2 = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date2;
    }
}
