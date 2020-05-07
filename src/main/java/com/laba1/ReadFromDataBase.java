package com.laba1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class ReadFromDataBase implements Read {
  static final String propertiesDataBase = "database.properties.txt";

  public List<String> readHoroscopeForecasts() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
      List<String> forecastsList = new ArrayList<>();
      try (Connection conn = getConnection()) {
        Statement statement = Objects.requireNonNull(conn).createStatement();
        ResultSet resultSet =
            statement.executeQuery("SELECT DISTINCT Forecasts FROM HoroscopeForecast");
        while (resultSet.next()) {
          forecastsList.add(resultSet.getString("Forecasts"));
        }
        return forecastsList;
      }
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return null;
  }

  public List<String> readWeatherForecasts() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
      List<String> forecastsList = new ArrayList<>();
      try (Connection conn = getConnection()) {
        Statement statement = Objects.requireNonNull(conn).createStatement();
        ResultSet resultSet =
            statement.executeQuery("SELECT DISTINCT Forecasts FROM WeatherForecast");
        while (resultSet.next()) {
          forecastsList.add(resultSet.getString("Forecasts"));
        }
        return forecastsList;
      }
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return null;
  }

  private static Connection getConnection() {
    File file = getFileFromResources(propertiesDataBase);
    Properties properties = new Properties();
    try {
      properties.load(new FileReader(file));
    } catch (IOException e) {
      e.printStackTrace();
    }
    String url = properties.getProperty("url");
    String username = properties.getProperty("username");
    String password = properties.getProperty("password");
    try {
      return DriverManager.getConnection(url, username, password);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }

  private static File getFileFromResources(String fileName) {
    ClassLoader classLoader = ReadFromDataBase.class.getClassLoader();
    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("file is not found!");
    } else {
      return new File(resource.getFile());
    }
  }
}
