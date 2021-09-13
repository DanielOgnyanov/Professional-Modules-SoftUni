import Homework.Homework;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        //  Before you start Read The ReadMe !!

        Homework homework = new Homework();


        homework.setConnection("root","fusco");  // Set Your User And Password

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of exercise to check the result:");
        int numberOfExToCheck = Integer.parseInt(scanner.nextLine());

        switch(numberOfExToCheck){

            case 2:
                homework.getVillainsNameEx2();
                break;

            case 3:
                homework.getMinionsNameEx3();
                break;
            case 4:
                homework.addMinionEx4();
                break;
            case 5:
                homework.changeTownsNameCasingEx5();
                break;
            case 7:
                homework.printAllMinionNamesEx7();
                break;
            case 8:
                homework.increaseMinionsAgeEx8();
                break;
            case 9:
                homework.increaseAgeEx9();
                break;

        }


    }
}
