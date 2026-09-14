import java.util.Scanner;

class Employee {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees created: " + employeeCount);
    }
}

public class EmployeeCompanyInformationManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name1 = sc.next();
        double salary1 = sc.nextDouble();

        String name2 = sc.next();
        double salary2 = sc.nextDouble();

        String name3 = sc.next();
        double salary3 = sc.nextDouble();

        Employee employee1 = new Employee(name1, salary1);
        Employee employee2 = new Employee(name2, salary2);
        Employee employee3 = new Employee(name3, salary3);

        Employee.printCompanyInfo();
    }
}