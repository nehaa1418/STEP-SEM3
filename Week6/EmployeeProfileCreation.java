import java.util.Scanner;

class Employee {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs "
                + salary + " | Intern: " + isIntern);
    }
}

public class EmployeeProfileCreation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String id1 = sc.next();
        String name1 = sc.next();
        double salary = sc.nextDouble();

        String id2 = sc.next();
        String name2 = sc.next();

        Employee permanent = new Employee(id1, name1, salary);
        Employee intern = new Employee(id2, name2);

        permanent.printProfile();
        intern.printProfile();
    }
}