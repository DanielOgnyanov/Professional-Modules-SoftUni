package SOLID.Controllers;

import SOLID.Enum.ReportLevel;
import SOLID.Interfaces.Appender;
import SOLID.Interfaces.File;
import SOLID.Interfaces.Layout;

public class FileAppender extends AbstractAppender {
    private File file;

    public FileAppender(ReportLevel reportLevel,Layout layout) {
        super(reportLevel,layout);
        this.file = new LogFile();
    }

    @Override
    protected String getType() {
        return "FileAppender";
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String massage) {
        String formatted = this.getLayout().format(date,reportLevel,massage);
        this.file.write(formatted);
        super.incrementAppendsCount();

    }

    @Override

    public String toString() {
        return  super.toString() + "File size: " + this.file.getFileSize();
    }
}
