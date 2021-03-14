package SOLID.Controllers;

import SOLID.Enum.ReportLevel;
import SOLID.Interfaces.Appender;
import SOLID.Interfaces.AppenderFactory;
import SOLID.Interfaces.Layout;

public class ControllerAppender implements AppenderFactory {
    @Override
    public Appender produce(String type, ReportLevel reportLevel, Layout layout) {

        return switch(type){
            case "ConsoleAppender" -> new ConsoleAppender(reportLevel,layout);
            case "FileAppender" -> new FileAppender(reportLevel,layout);
            default -> throw new IllegalArgumentException("Not valid type of appender for " + type);

        };
    }
}
