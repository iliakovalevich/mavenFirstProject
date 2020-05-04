package com.laba1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class InputOutputFile implements ReadFromFileInterface {
  public List<String> readTxtFile(String pathname) {
    InputOutputFile inputOutputFile = new InputOutputFile();
    File file = inputOutputFile.getFileFromResources(pathname);
    List<String> forecastsList = new ArrayList<>();
    try (FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        forecastsList.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return forecastsList;
  }

  public JSONArray readJsonFile(String pathname, String arrayName) {
    InputOutputFile inputOutputFile = new InputOutputFile();
    File file = inputOutputFile.getFileFromResources(pathname);
    StringBuilder stringBuilder = new StringBuilder();
    try (FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    JSONObject weatherJsonObject =
            null;
    try {
      weatherJsonObject = (JSONObject) JSONValue.parseWithException(stringBuilder.toString());
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return (JSONArray) weatherJsonObject.get(arrayName);
  }

  public File getFileFromResources(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("file is not found!");
    } else {
      return new File(resource.getFile());
    }
  }
}
