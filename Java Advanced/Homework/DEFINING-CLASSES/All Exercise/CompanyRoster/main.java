package DefiningClasses.CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> departmentSalary = new TreeMap<>();
        List<Employee> person = new ArrayList<>();
        int countPeople = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < countPeople; i++) {
            String name = "";
            double salary = 0.0;
            String position = "";
            String department = "";
            String email = "n/a";
            int age = -1;

            String command = scanner.nextLine();
            String[] operations = command.split("\\s+");

            name = operations[0];
            salary = Double.parseDouble(operations[1]);
            position = operations[2];
            department = operations[3];

            if (operations.length - 1 >= 4) {
                if (operations[4].toCharArray().length <= 2) {
                    age = Integer.parseInt(operations[4]);
                } else {
                    email = operations[4];
                }


            }
            if (operations.length - 1 == 5) {
                age = Integer.parseInt(operations[5]);
            }

            Employee employee = new Employee(name, salary, position, department, email, age);
            person.add(employee);

        }

        for (Employee iterate : person) {
            if (departmentSalary.containsKey(iterate.department)) {
                departmentSalary.put(iterate.department, departmentSalary.get(iterate.department) + iterate.salary);
            } else {
                departmentSalary.put(iterate.department, iterate.salary);
            }


        }

        Map<String, Double> topSalary =
                departmentSalary.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        String topDepartment = "";
        for (Map.Entry<String, Double> toPrint : topSalary.entrySet()) {
            System.out.printf("Highest Average Salary: %s\n", toPrint.getKey());
            topDepartment = toPrint.getKey();
            break;
        }
        Collections.sort(person, (c1, c2) -> {
            if (c1.salary > c2.salary) return -1;
            if (c1.salary < c2.salary) return 1;
            return 0;
        });


        for (Employee people : person) {
            if (people.department.equals(topDepartment)) {
                System.out.printf("%s %.2f %s %d\n",
                        people.name, people.salary, people.email, people.age);
            }
        }


    }
}
