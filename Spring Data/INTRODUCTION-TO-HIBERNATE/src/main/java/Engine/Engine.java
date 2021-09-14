package Engine;

import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {


    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of ex. to check: ");

        int exNumberToCheck = Integer.parseInt(scanner.nextLine());


        switch (exNumberToCheck) {
            case 2:
                changeCasingEx2();
                break;
            case 3:
                try {
                    containsEmployeeEx3();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                employeesWithSalaryOver50000();
                break;
            case 5:
                employeesFromDepartmentsEx5();
                break;
            case 6:
                try {
                    addingNewAddressAndUpdatingEmpEx6();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 7:
                addressesWithEmployeeCountEx7();
                break;
            case 8:
                try {
                    getEmployeeWithProjectEx8();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 9:
                findLatest10ProjectEx9();
                break;
            case 10:
                increaseSalaryEx10();
                break;
            case 11:
                try {
                    findEmployeesByFirstNameEx11();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 12:
                employeeMaxSalaryEx12();
                break;
            case 13:
                try {
                    removeTownsEx13();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }


    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    // EX 2


    private void changeCasingEx2() {
        List<Town> towns = entityManager.createQuery("SELECT t FROM Town t " +
                "WHERE length(t.name) <= 5 ", Town.class)
                .getResultList();

        entityManager.getTransaction().begin();
        towns.forEach(entityManager::detach);

        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());
        }

        towns.forEach(entityManager::merge);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////

    // EX 3

    private void containsEmployeeEx3() throws IOException {

        System.out.println("Enter full name of the employee separated by space: ");

        String fullName = reader.readLine();


        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE CONCAT(e.firstName, ' ' , e.lastName) = :name", Employee.class)
                .setParameter("name", fullName)
                .getResultList();

        System.out.println(employees.size() == 0 ? "NO" : "YES");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////


    // EX 4


    private void employeesWithSalaryOver50000() {
        List<Employee> employees = entityManager.
                createQuery("SELECT e FROM Employee e " +
                        "WHERE e.salary > 50000", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////


    // EX 5

    private void employeesFromDepartmentsEx5() {
        List<Employee> employees = entityManager.
                createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = 'Research and Development' " +
                        "ORDER BY e.salary,e.id", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s from Research and Development - $%.2f%n",
                    employee.getFirstName(), employee.getLastName(), employee.getSalary());
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    // EX 6

    private void addingNewAddressAndUpdatingEmpEx6() throws IOException {

        Address address = createAddress("Vitoshka 15");

        System.out.println("Enter unique last name: ");
        String lastName = reader.readLine();

        List<Employee> employee = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName = :name", Employee.class)
                .setParameter("name", lastName)
                .getResultList();

        entityManager.getTransaction().begin();
        employee.get(0).setAddress(address);
        entityManager.getTransaction().commit();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////


    // EX 7


    private void addressesWithEmployeeCountEx7() {

        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        for (Address address : addresses) {
            System.out.printf("%s, %s - %d %n",
                    address.getText(), address.getTown().getName(),
                    address.getEmployees().size());
        }


    }


    //////////////////////////////////////////////////////////////////////////////////////////////////


    // EX 8

    private void getEmployeeWithProjectEx8() throws IOException {
        System.out.println("Enter valid employee id: ");

        int id = Integer.parseInt(reader.readLine());

        Employee employee = entityManager.find(Employee.class, id);

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project ->
                        System.out.printf("\t%s%n", project.getName()));

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////


    // EX 9


    private void findLatest10ProjectEx9() {

        List<Project> projects = entityManager.
                createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate DESC", Project.class)
                .getResultList();


        projects.stream()
                .sorted(Comparator.comparing(Project::getName))
                .limit(10)
                .forEach(project -> {
                            System.out.printf("Project name: %s%n", project.getName());
                            System.out.printf("       Project Description: %s%n", project.getDescription());
                            System.out.println("       Project Start Date:" + project.getStartDate());
                            System.out.println("       Project End Date:" + project.getEndDate());
                        }
                );

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////


    // EX 10


    private void increaseSalaryEx10() {

        entityManager.getTransaction().begin();
        int affectedRows = entityManager
                .createQuery("UPDATE Employee  e " +
                        "SET e.salary = e.salary * 1.12 " +
                        "WHERE e.department.id IN (1,2,4,11)")
                .executeUpdate();
        entityManager.getTransaction().commit();


        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.id IN (1,2,4,11)", Employee.class)
                .getResultStream()
                .forEach(employee ->
                        System.out.printf("%s %s ($%.2f)%n",
                                employee.getFirstName(), employee.getLastName(),
                                employee.getSalary()));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////


    // EX 11


    private void findEmployeesByFirstNameEx11() throws IOException {
        System.out.println("Enter pattern: ");
        String patt = reader.readLine();

        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.firstName LIKE :patt", Employee.class)
                .setParameter("patt", patt + "%")
                .getResultList();

        employees.stream()
                .forEach(employee ->
                        System.out.printf("%s %s - %s - ($%.2f)%n", employee.getFirstName()
                                , employee.getLastName(), employee.getJobTitle(), employee.getSalary()));


    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////


    //EX 12


    private void employeeMaxSalaryEx12() {
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.salary < 30000 OR e.salary > 70000 " +
                        "GROUP BY e.department.id " +
                        "ORDER BY e.salary ", Employee.class)
                .getResultList();


        employees.stream()
                .sorted(Comparator
                        .comparing(e -> e
                                .getDepartment()
                                .getId()))
                .forEach(e -> System.out.printf("%s - %.2f%n",
                        e.getDepartment().getName(),
                        e.getSalary()));


    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////


    // EX 13


    private void removeTownsEx13() throws IOException {
        System.out.printf("Enter name of town to delete: ");
        String deleteTown = reader.readLine();

        Town town = entityManager
                .createQuery("SELECT t FROM Town AS t WHERE t.name = :townName", Town.class)
                .setParameter("townName", deleteTown)
                .getSingleResult();


        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address AS a WHERE a.town.name = :townName", Address.class)
                .setParameter("townName", deleteTown)
                .getResultList();

        String output = String.format("%d address%s in %s deleted%n",
                addresses.size(), (addresses.size() != 1) ? "es" : "", town.getName());


        entityManager.getTransaction().begin();
        addresses.forEach(address -> {
            for (Employee employee : address.getEmployees()) {
                employee.setAddress(null);
            }
            address.setTown(null);
            entityManager.remove(address);
        });


        entityManager.remove(town);

        entityManager.getTransaction().commit();

        System.out.println(output);

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////

    // METHOD
    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }


}
