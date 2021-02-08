package DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        List<Person> allPersonInfo = new ArrayList<>();
        List<String> allNamePerson = new ArrayList<>();

        while (!command.equals("End")) {
            String[] operations = command.split("\\s+");

            String currNamePerson = operations[0];


            List<String> companyInfo = new ArrayList<>();
            String company = "";
            String department = "";
            String salary = "";


            List<String> allPokemon = new ArrayList<>();
            String namePokemon = "";
            String typePokemon = "";


            List<String> parents = new ArrayList<>();
            String parentName = "";
            String birthday = "";


            List<String> children = new ArrayList<>();
            String childName = "";
            String childBirthday = "";


            String carModel = "";
            String carSpeed = "";
            List<String> car = new ArrayList<>();

            String checkType = operations[1];

            switch (checkType) {


                case "company":
                    company = operations[2];
                    department = operations[3];
                    salary = operations[4];
                    companyInfo.add(company);
                    companyInfo.add(department);
                    companyInfo.add(salary);
                    break;

                case "pokemon":
                    namePokemon = operations[2];
                    typePokemon = operations[3];
                    allPokemon.add(namePokemon);
                    allPokemon.add(typePokemon);
                    break;

                case "parents":
                    parentName = operations[2];
                    birthday = operations[3];
                    parents.add(parentName);
                    parents.add(birthday);
                    break;

                case "children":
                    childName = operations[2];
                    childBirthday = operations[3];
                    children.add(childName);
                    children.add(childBirthday);
                    break;

                case "car":
                    carModel = operations[2];
                    carSpeed = operations[3];
                    car.add(carModel);
                    car.add(carSpeed);
                    break;

            }

            Person person = new Person(currNamePerson, companyInfo, allPokemon, parents, children, car);
            if (allPersonInfo.isEmpty()) {
                allPersonInfo.add(person);
                if (!allNamePerson.contains(currNamePerson)) {
                    allNamePerson.add(currNamePerson);
                }
            } else {
                for (Person checkIfContainsAlreadyThePerson : allPersonInfo) {

                    if (allNamePerson.contains(currNamePerson)) {

                        if (checkIfContainsAlreadyThePerson.name.equals(currNamePerson)) {
                            switch (checkType) {
                                case "company":
                                    if (checkIfContainsAlreadyThePerson.companyInfo.isEmpty()) {
                                        checkIfContainsAlreadyThePerson.companyInfo.add(company);
                                        checkIfContainsAlreadyThePerson.companyInfo.add(department);
                                        checkIfContainsAlreadyThePerson.companyInfo.add(salary);
                                    }
                                    break;
                                case "pokemon":
                                    checkIfContainsAlreadyThePerson.allPokemon.add(namePokemon);
                                    checkIfContainsAlreadyThePerson.allPokemon.add(typePokemon);
                                    break;

                                case "parents":
                                    checkIfContainsAlreadyThePerson.parents.add(parentName);
                                    checkIfContainsAlreadyThePerson.parents.add(birthday);
                                    break;

                                case "children":
                                    checkIfContainsAlreadyThePerson.children.add(childName);
                                    checkIfContainsAlreadyThePerson.children.add(childBirthday);
                                    break;

                                case "car":
                                    if (checkIfContainsAlreadyThePerson.car.isEmpty()) {
                                        checkIfContainsAlreadyThePerson.car.add(carModel);
                                        checkIfContainsAlreadyThePerson.car.add(carSpeed);
                                    }
                                    break;
                            }
                            break;
                        }

                    }


                    if (!allNamePerson.contains(currNamePerson)) {
                        allNamePerson.add(currNamePerson);
                        allPersonInfo.add(person);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        for (Person toPrint : allPersonInfo) {

            for (String namePerson : allNamePerson) {
                if (namePerson.equals(command)) {

                    if (toPrint.name.equals(namePerson)) {

                        System.out.println(namePerson);


                        if (toPrint.companyInfo.isEmpty()) {
                            System.out.println("Company:");
                        } else {
                            System.out.println("Company:");
                            for (int i = 0; i < toPrint.companyInfo.size(); i++) {
                                if (toPrint.companyInfo.size() - 1 == i) {
                                    double salaryAsDouble = Double.parseDouble(toPrint.companyInfo.get(i));
                                    System.out.printf("%.2f", salaryAsDouble);
                                } else {
                                    System.out.print(toPrint.companyInfo.get(i) + " ");
                                }
                            }
                            System.out.println();
                        }


                        if (toPrint.car.isEmpty()) {
                            System.out.println("Car:");
                        } else {
                            System.out.println("Car:");
                            for (int i = 0; i < toPrint.car.size(); i++) {
                                if (toPrint.car.size() - 1 == i) {
                                    System.out.print(toPrint.car.get(i));
                                } else {
                                    System.out.print(toPrint.car.get(i) + " ");
                                }
                            }
                            System.out.println();
                        }


                        if (toPrint.allPokemon.isEmpty()) {
                            System.out.println("Pokemon:");
                        } else {
                            System.out.println("Pokemon:");
                            int j = 0;
                            for (int i = 0; i < toPrint.allPokemon.size(); i++) {
                                if (j == 1) {
                                    System.out.print(toPrint.allPokemon.get(i));
                                } else if (j == 2) {
                                    System.out.println();
                                    System.out.print(toPrint.allPokemon.get(i) + " ");
                                    j = 0;
                                } else if (j == 0) {
                                    System.out.print(toPrint.allPokemon.get(i) + " ");
                                }
                                j++;
                            }
                            j = 0;
                            System.out.println();
                        }


                        if (toPrint.parents.isEmpty()) {
                            System.out.println("Parents:");
                        } else {
                            System.out.println("Parents:");
                            int j = 0;
                            for (int i = 0; i < toPrint.parents.size(); i++) {
                                if (j == 1) {
                                    System.out.print(toPrint.parents.get(i));
                                } else if (j == 2) {
                                    System.out.println();
                                    System.out.print(toPrint.parents.get(i) + " ");
                                    j = 0;
                                } else if (j == 0) {
                                    System.out.print(toPrint.parents.get(i) + " ");
                                }
                                j++;
                            }
                            j = 0;
                            System.out.println();

                        }


                        if (toPrint.children.isEmpty()) {
                            System.out.println("Children:");
                        } else {
                            System.out.println("Children:");
                            int j = 0;
                            for (int i = 0; i < toPrint.children.size(); i++) {
                                if (j == 1) {
                                    System.out.print(toPrint.children.get(i));
                                } else if (j == 2) {
                                    System.out.println();
                                    System.out.print(toPrint.children.get(i) + " ");
                                    j = 0;
                                } else if (j == 0) {
                                    System.out.print(toPrint.children.get(i) + " ");
                                }
                                j++;
                            }
                            j = 0;
                            return;

                        }

                    }

                }

            }
        }
    }
}
