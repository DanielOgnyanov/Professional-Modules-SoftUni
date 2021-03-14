package SOLID.Controllers;

import SOLID.Enum.ReportLevel;
import SOLID.Interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String date, ReportLevel reportLevel, String massage) {
        return String.format("%s - %s - %s", date,reportLevel.toString(),massage);
    }

    @Override
    public String getType() {
        return "SimpleLayout";
    }
}
