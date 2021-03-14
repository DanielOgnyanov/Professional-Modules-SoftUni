package SOLID.Controllers;

import SOLID.Enum.ReportLevel;

public class XmlLayout implements SOLID.Interfaces.Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String massage) {
        return String.format("<log>%n" +
                "<date>%s</date>%n" +
                "<message>%s</message>%n" +
                "<log>", date,reportLevel.toString(),massage);
    }

    @Override
    public String getType() {
        return "XmlLayout";
    }
}
