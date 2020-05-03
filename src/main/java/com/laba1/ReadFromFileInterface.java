package com.laba1;

import java.io.File;
import java.util.List;

public interface ReadFromFileInterface {
  File getFileFromResources(String fileName);

  List<String> readTxtFile(String pathname);
}
