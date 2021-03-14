package SOLID.Logger;

import SOLID.Enum.ReportLevel;
import SOLID.Interfaces.Appender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract  class AbstractLogger implements  Logger{
    private List<Appender> appender;


    public AbstractLogger(Appender... appender) {
        this.appender = new ArrayList<>(Arrays.asList(appender));
    }


    @Override
    public void logInfo(String date, String message) {
        callAppender(date, message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String date, String message) {
        callAppender(date, message, ReportLevel.WARNING);
    }

    @Override
    public void logError(String date, String message) {
        callAppender(date, message, ReportLevel.ERROR);
    }

    @Override
    public void logCritical(String date, String message) {
        callAppender(date, message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String date, String message) {
        callAppender(date, message, ReportLevel.FATAL);
    }

    private void callAppender(String date, String message, ReportLevel info) {
        for (Appender append : appender) {

            if (append.getReportLevel().ordinal() <= info.ordinal()) {
                append.append(date,info,message);
            }

        }
    }

    @Override
    public void addAppender(Appender appender) {
        this.appender.add(appender);
    }

    @Override

    public String toString()  {
        StringBuilder builder = new StringBuilder("Logger info")
                .append(System.lineSeparator());

        builder.append(this.appender.stream()
        .map(Appender::toString)
                .collect(Collectors.joining(System.lineSeparator())));

        return builder.toString();
    }
}
