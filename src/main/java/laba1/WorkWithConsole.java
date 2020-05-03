package laba1;

import java.util.Date;

public interface WorkWithConsole {
  void printMenu();

  int inputNumberOfMenu(int minValue, int maxValue);

  void printPeriod();

  Date inputDate(String s);
}
