package SOLID;

import SOLID.Controllers.ConsoleAppender;
import SOLID.Controllers.ControllerAppender;
import SOLID.Controllers.SimpleLayout;
import SOLID.Enum.ReportLevel;
import SOLID.Interfaces.Appender;
import SOLID.Interfaces.AppenderFactory;
import SOLID.Interfaces.Layout;
import SOLID.Interfaces.LayoutFactory;
import SOLID.Logger.Logger;
import SOLID.Logger.MessageLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());


        AppenderFactory appenderFactory = new ControllerAppender();
        LayoutFactory layoutFactory = new SOLID.Controllers.Layout(); ////

        Logger logger = new MessageLogger();

        while (count-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");

            ReportLevel reportLevel = tokens.length == 3
                    ? ReportLevel.valueOf(tokens[2].toUpperCase())
                    : ReportLevel.INFO;

            Appender app = appenderFactory.produce(tokens[0],reportLevel,layoutFactory.produce(tokens[1]));

           logger.addAppender(app);

        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
           String[] split = input.split("\\|");

           ReportLevel reportLevel = ReportLevel.valueOf(split[0]);
           String date = split[1];
           String message = split[2];

           switch (reportLevel) {
               case INFO -> logger.logInfo(date,message);
               case WARNING -> logger.logWarning(date,message);
               case ERROR -> logger.logError(date,message);
               case CRITICAL -> logger.logCritical(date,message);
               case FATAL -> logger.logFatal(date,message);

               default -> throw new IllegalStateException("Unknown enum value for " + reportLevel);
           }

            input = scanner.nextLine();
        }
        System.out.println(logger.toString());

    }

}
