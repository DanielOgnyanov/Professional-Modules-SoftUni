package SOLID.Interfaces;

import SOLID.Enum.ReportLevel;

public interface Layout {
   String format(String date, ReportLevel reportLevel, String massage);

    String getType();
}

