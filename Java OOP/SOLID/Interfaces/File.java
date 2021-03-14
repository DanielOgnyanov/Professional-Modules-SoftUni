package SOLID.Interfaces;

import SOLID.Enum.ReportLevel;

public interface File {
    void write(String text);
    int getFileSize();
}
