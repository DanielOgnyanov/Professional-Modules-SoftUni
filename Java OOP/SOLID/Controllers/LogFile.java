package SOLID.Controllers;

import SOLID.Enum.ReportLevel;
import SOLID.Interfaces.File;

public class LogFile implements File {

    public LogFile() {
        this.stringBuilder = new StringBuilder();
    }

    private StringBuilder stringBuilder;


    @Override
    public void write(String text) {
        this.stringBuilder.append(text);

    }

    @Override
    public int getFileSize() {
        int sum = 0;

        for (int i = 0; i < this.stringBuilder.length() ; i++) {
            char curr = stringBuilder.charAt(i);

            if(Character.isAlphabetic(curr))  {
                sum += curr;
            }
        }
        return sum;
    }
}
