package DefiningClasses.CompanyRoster;

public class Employee {





    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    String name;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    double salary;
    String position;
    String department;
    String email;
    int age;


}
