package laba1;

import java.io.File;
import java.util.ArrayList;

public interface ReadFromFile {
    File getFileFromResources(String fileName);
    ArrayList<String> readTxtFile(String pathname);
}
