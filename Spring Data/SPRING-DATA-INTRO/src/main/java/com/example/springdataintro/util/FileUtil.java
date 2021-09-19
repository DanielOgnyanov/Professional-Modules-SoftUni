package com.example.springdataintro.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUtil {
    String[] readFileContent(String filePath) throws IOException;
}
