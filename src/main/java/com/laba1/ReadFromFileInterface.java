package com.laba1;

import org.json.simple.JSONArray;

import java.io.File;
import java.util.List;

public interface ReadFromFileInterface {
  File getFileFromResources(String fileName);

  JSONArray readJsonFile(String pathname, String arrayName);

  List<String> readTxtFile(String pathname);
}
