package Defining_Classes.CompanyRoster;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Department> departments = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String employeeData = scanner.nextLine();
            String[] parameters = employeeData.split("\\s+");

            String name = parameters[0];
            double salary = Double.parseDouble(parameters[1]);
            String position = parameters[2];
            String department = parameters[3];
            Employee employee = null;
            if (parameters.length == 6) {
                String email = parameters[4];
                int age = Integer.parseInt(parameters[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (parameters.length == 5) {
                if (parameters[4].contains("@")) {
                    String email = parameters[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(parameters[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
                //или с try/catch пробвам да Parse-на

            } else if (parameters.length == 4) {
                employee = new Employee(name, salary, position, department);
            }

            if (!departments.containsKey(department)) {
                departments.put(department, new Department(department));
            }
            departments.get(department).getEmployees().add(employee);

        }
        Department maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparing(entry-> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2)-> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee-> System.out.println(employee.toString()));
    }
}
