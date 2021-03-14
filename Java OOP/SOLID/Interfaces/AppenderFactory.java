package SOLID.Interfaces;

import SOLID.Enum.ReportLevel;

public interface AppenderFactory {
    Appender produce(String type, ReportLevel reportLevel, Layout layout);
}
