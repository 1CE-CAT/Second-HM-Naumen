package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иванов Иван Иванович",   30, "IT",       80000),
            new Employee("Петрова Анна Сергеевна", 25, "HR",       60000),
            new Employee("Сидоров Пётр Алексеевич",45, "Finance",  120000),
            new Employee("Кузнецова Мария Ивановна",35, "IT",       95000),
            new Employee("Смирнов Алексей Петрович",28, "Marketing", 70000)
        ));

        System.out.print("Enter Department: ");
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        sc.close();

        OptionalDouble avg = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(n))
                .mapToDouble(Employee::getSalary)
                .average();

        if (avg.isPresent()) {
            System.out.printf("Средняя зарплата отдела %s: %.2f%n", n, avg.getAsDouble());
        } else {
            System.out.println("Сотрудников в отделе " + n + " не найдено.");
        }
    }
}