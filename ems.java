import java.util.*;

class Employee {
    int id, age;
    String name, email, department;
    double salary;
    String attendance = "Not Marked";
    double performance = 0;

    Employee(int id, String name, int age, String email,
             String department, double salary) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }
}

public class ems{

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Employee> employees = new ArrayList<>();

    static ArrayList<String> departments = new ArrayList<>();

    static void dashboard() {

        double totalSalary = 0;

        System.out.println("\n---------DASHBOARD---------");

        System.out.println("Total Employees: " + employees.size());

        System.out.println("Total Departments: " + departments.size());

        for (Employee e : employees) {
            totalSalary += e.salary;
        }

        System.out.println("Total Salary Expense: " + totalSalary);

        System.out.println("-------------------------");
    }

    static Employee findEmployee(int id) {

        for (Employee e : employees) {
            if (e.id == id) {
                return e;
            }
        }

        return null;
    }

    // ADD EMPLOYEE

    static void addEmployee() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findEmployee(id) != null) {
            System.out.println("Employee ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees.add(new Employee(
            id, name, age, email, department, salary
        ));

        if (!departments.contains(department)) {
            departments.add(department);
        }

        System.out.println("Employee Added Successfully!");
    }

    // VIEW EMPLOYEES

    static void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No Employees Found!");
            return;
        }

        System.out.println("\n========== EMPLOYEE RECORDS ==========");

        for (Employee e : employees) {

            System.out.println("\nID: " + e.id);
            System.out.println("Name: " + e.name);
            System.out.println("Age: " + e.age);
            System.out.println("Email: " + e.email);
            System.out.println("Department: " + e.department);
            System.out.println("Salary: " + e.salary);
            System.out.println("Attendance: " + e.attendance);
            System.out.println("Performance: " + e.performance);

            System.out.println("--------------------------------");
        }
    }

    // SEARCH EMPLOYEE

    static void searchEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = findEmployee(id);

        if (e != null) {
            System.out.println("Employee Found!");
            System.out.println("Name: " + e.name);
            System.out.println("Department: " + e.department);
            System.out.println("Salary: " + e.salary);
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    // UPDATE EMPLOYEE

    static void updateEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee e = findEmployee(id);

        if (e == null) {
            System.out.println("Employee Not Found!");
            return;
        }

        System.out.print("Enter New Name: ");
        e.name = sc.nextLine();

        System.out.print("Enter New Email: ");
        e.email = sc.nextLine();

        System.out.print("Enter New Department: ");
        String newDepartment = sc.nextLine();

        e.department = newDepartment;

        if (!departments.contains(newDepartment)) {
            departments.add(newDepartment);
        }

        System.out.print("Enter New Salary: ");
        e.salary = sc.nextDouble();

        System.out.println("Employee Updated Successfully!");
    }

    // DELETE EMPLOYEE

    static void deleteEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = findEmployee(id);

        if (e != null) {
            employees.remove(e);
            System.out.println("Employee Deleted Successfully!");
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    // DEPARTMENT MANAGEMENT

    static void viewDepartments() {

        System.out.println("\n========== DEPARTMENTS ==========");

        if (departments.isEmpty()) {
            System.out.println("No Departments Found!");
            return;
        }

        for (String d : departments) {

            int count = 0;

            for (Employee e : employees) {
                if (e.department.equalsIgnoreCase(d)) {
                    count++;
                }
            }

            System.out.println(d + " - " + count + " Employees");
        }
    }

    // ATTENDANCE MANAGEMENT

    static void markAttendance() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = findEmployee(id);

        if (e == null) {
            System.out.println("Employee Not Found!");
            return;
        }

        System.out.println("1. Present");
        System.out.println("2. Absent");

        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            e.attendance = "Present";
        } else if (choice == 2) {
            e.attendance = "Absent";
        } else {
            System.out.println("Invalid Choice!");
            return;
        }

        System.out.println("Attendance Marked Successfully!");
    }

    // LEAVE MANAGEMENT

    static void applyLeave() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = findEmployee(id);

        if (e == null) {
            System.out.println("Employee Not Found!");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Leave Reason: ");
        String reason = sc.nextLine();

        System.out.println("Leave Application Submitted!");
        System.out.println("Employee: " + e.name);
        System.out.println("Reason: " + reason);
        System.out.println("Status: Pending");
    }

    // SALARY MANAGEMENT

    static void calculateSalary() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = findEmployee(id);

        if (e == null) {
            System.out.println("Employee Not Found!");
            return;
        }

        System.out.print("Enter Bonus: ");
        double bonus = sc.nextDouble();

        System.out.print("Enter Deduction: ");
        double deduction = sc.nextDouble();

        double netSalary = e.salary + bonus - deduction;

        System.out.println("\n========== SALARY SLIP ==========");
        System.out.println("Employee Name: " + e.name);
        System.out.println("Basic Salary: " + e.salary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Deduction: " + deduction);
        System.out.println("Net Salary: " + netSalary);
        System.out.println("=================================");
    }

    // PERFORMANCE MANAGEMENT

    static void performance() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = findEmployee(id);

        if (e == null) {
            System.out.println("Employee Not Found!");
            return;
        }

        System.out.print("Enter Performance Rating (1-10): ");
        double rating = sc.nextDouble();

        if (rating < 1 || rating > 10) {
            System.out.println("Invalid Rating!");
            return;
        }

        e.performance = rating;

        System.out.println("Performance Updated Successfully!");
    }

    // MAIN METHOD

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("   EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Dashboard");
            System.out.println("2. Add Employee");
            System.out.println("3. View Employees");
            System.out.println("4. Search Employee");
            System.out.println("5. Update Employee");
            System.out.println("6. Delete Employee");
            System.out.println("7. Department Management");
            System.out.println("8. Attendance Management");
            System.out.println("9. Leave Management");
            System.out.println("10. Salary Management");
            System.out.println("11. Performance Management");
            System.out.println("12. Exit");

            System.out.print("\nEnter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    dashboard();
                    break;

                case 2:
                    addEmployee();
                    break;

                case 3:
                    viewEmployees();
                    break;

                case 4:
                    searchEmployee();
                    break;

                case 5:
                    updateEmployee();
                    break;

                case 6:
                    deleteEmployee();
                    break;

                case 7:
                    viewDepartments();
                    break;

                case 8:
                    markAttendance();
                    break;

                case 9:
                    applyLeave();
                    break;

                case 10:
                    calculateSalary();
                    break;

                case 11:
                    performance();
                    break;

                case 12:
                    System.out.println("Thank You For Using EMS!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 12);

        sc.close();
    }
}