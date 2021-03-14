package SOLID.Interfaces;

import SOLID.Enum.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);
    ReportLevel getReportLevel();
}
