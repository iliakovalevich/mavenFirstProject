package com.laba1;

import java.io.File;
import java.util.List;

public interface Read {
  List<String> readHoroscopeForecasts();

  List<String> readWeatherForecasts();

  File getFileFromResources(String fileName);
}
