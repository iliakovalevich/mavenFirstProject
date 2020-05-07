package com.laba1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class ReadJsonFile implements Read {
  static final String weatherFileJson = "weatherForecast.json";
  static final String horoscopeFileJson = "horoscopeForecast.json";
  static final String horoscopeArrayName = "horoscope";
  static final String weatherArrayName = "weather";

  @Override
  public JSONArray readHoroscopeForecasts() {
    StringBuilder stringBuilder = new StringBuilder();
    try (FileReader reader = new FileReader(getFileFromResources(horoscopeFileJson));
        BufferedReader bufferedReader = new BufferedReader(reader)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    JSONObject weatherJsonObject = null;
    try {
      weatherJsonObject = (JSONObject) JSONValue.parseWithException(stringBuilder.toString());
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return (JSONArray) Objects.requireNonNull(weatherJsonObject).get(horoscopeArrayName);
  }

  @Override
  public JSONArray readWeatherForecasts() {
    StringBuilder stringBuilder = new StringBuilder();
    try (FileReader reader = new FileReader(getFileFromResources(weatherFileJson));
        BufferedReader bufferedReader = new BufferedReader(reader)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    JSONObject weatherJsonObject = null;
    try {
      weatherJsonObject = (JSONObject) JSONValue.parseWithException(stringBuilder.toString());
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return (JSONArray) Objects.requireNonNull(weatherJsonObject).get(weatherArrayName);
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
