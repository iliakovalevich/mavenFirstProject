package com.laba1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReadCsvFile implements Read {
  static final String horoscopeFileCsv = "csvHoroscope.csv";
  static final String weatherFileCsv = "csvWeather.csv";

  @Override
  public List<String> readHoroscopeForecasts() {
    List<String> horoscopeForecastsList = new ArrayList<>();
    try (FileReader reader = new FileReader(getFileFromResources(horoscopeFileCsv));
        BufferedReader bufferedReader = new BufferedReader(reader)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        horoscopeForecastsList.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return horoscopeForecastsList;
  }

  @Override
  public List<String> readWeatherForecasts() {
    List<String> weatherForecastsList = new ArrayList<>();
    try (FileReader reader = new FileReader(getFileFromResources(weatherFileCsv));
        BufferedReader bufferedReader = new BufferedReader(reader)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        weatherForecastsList.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return weatherForecastsList;
  }

  private static File getFileFromResources(String fileName) {
    ClassLoader classLoader = ReadTxtFile.class.getClassLoader();
    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("file is not found!");
    } else {
      return new File(resource.getFile());
    }
  }
}
