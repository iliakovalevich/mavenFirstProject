package com.laba1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadJsonFile implements Read {
  private static final String WEATHER_FILE_JSON = "weatherForecast.json";
  private static final String HOROSCOPE_FILE_JSON = "horoscopeForecast.json";
  private static final String HOROSCOPE_ARRAY_NAME = "horoscope";
  private static final String WEATHER_ARRAY_NAME = "weather";

  @Override
  public JSONArray readHoroscopeForecasts() {
    StringBuilder stringBuilder = new StringBuilder();
    try (FileReader reader = new FileReader(getFileFromResources(HOROSCOPE_FILE_JSON));
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
    return (JSONArray) Objects.requireNonNull(weatherJsonObject).get(HOROSCOPE_ARRAY_NAME);
  }

  @Override
  public JSONArray readWeatherForecasts() {
    StringBuilder stringBuilder = new StringBuilder();
    try (FileReader reader = new FileReader(getFileFromResources(WEATHER_FILE_JSON));
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
    return (JSONArray) Objects.requireNonNull(weatherJsonObject).get(WEATHER_ARRAY_NAME);
  }

  public File getFileFromResources(String fileName) {
    ClassLoader classLoader = ReadTxtFile.class.getClassLoader();
    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("file is not found!");
    } else {
      return new File(resource.getFile());
    }
  }
}
